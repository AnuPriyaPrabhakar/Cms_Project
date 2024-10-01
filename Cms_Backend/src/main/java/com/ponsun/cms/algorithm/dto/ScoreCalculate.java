package com.ponsun.cms.algorithm.dto;

import com.ponsun.cms.algorithm.cdo.CriminalRuleCDO;
import com.ponsun.cms.commonDetails.data.StatusDetailsData;
import com.ponsun.cms.commonSearch.data.RecordsDto;
import com.ponsun.cms.commonSearch.data.SearchDto;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.SearchDetails.SearchDetails.services.SearchDetailsWritePlatformService;
import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;
import com.ponsun.cms.SearchDetails.Search.services.SearchWritePlatformService;
import info.debatty.java.stringsimilarity.JaroWinkler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static me.xdrop.fuzzywuzzy.FuzzySearch.tokenSetPartialRatio;
import static org.apache.commons.math3.util.Precision.round;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScoreCalculate {
    private final JdbcTemplate jdbcTemplate;
    private final KieContainer kieContainer;
    private final SearchWritePlatformService searchWritePlatformService;
    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;
    JaroWinkler jw = new JaroWinkler();

    @Transactional
    public List<RecordsDto> calculateScore(SearchDto searchDTO, List<StatusDetailsData> statusDetailsDataList) {
        List<RecordsDto> recordDTOS = new ArrayList<>();

        String queryCustomer = searchDTO.getName();
        Double matching_score = searchDTO.getMatching_score();

        ModelMapper modelMapper = new ModelMapper();
        CreateSearchRequest request = modelMapper.map(searchDTO, CreateSearchRequest.class);
        Response response = this.searchWritePlatformService.createSearch(request);

        for (StatusDetailsData statusDetailsData : statusDetailsDataList) {

            String str2 = statusDetailsData.getCmsName();
            String value1 = tokenSetPartialRatio(queryCustomer, str2) + "";
            String value2 = jw.similarity(queryCustomer, str2) + "";

            boolean isCriminalScoreVerified = isCriminalRulePassed(value1, value2, matching_score);
            if (isCriminalScoreVerified) {

                RecordsDto recordDTO = new RecordsDto();
                recordDTO.setCmsId(statusDetailsData.getCmsId());
                recordDTO.setCmsName(statusDetailsData.getCmsName());
                recordDTO.setCmsRecordType(statusDetailsData.getCmsRecordType());
                recordDTO.setRecordTypeId(statusDetailsData.getRecordTypeId());
                recordDTO.setScore(Math.max(Double.parseDouble(value1), round(Double.parseDouble(value2) * 100, 0)));
                recordDTOS.add(recordDTO);

                SearchDetailsData searchDetailsData = new SearchDetailsData();
                searchDetailsData.setSearchId((Integer) response.getId());
                searchDetailsData.setCmsId(recordDTO.getCmsId());
                searchDetailsData.setName(recordDTO.getCmsName());
                searchDetailsData.setSearchingScore(recordDTO.getScore());
                searchDetailsData.setTypeId(searchDetailsData.getTypeId());

                CreateSearchDetailsRequest request1 = modelMapper.map(searchDetailsData, CreateSearchDetailsRequest.class);
                Response response1 = this.searchDetailsWritePlatformService.createSearchDetails(request1);
            }
            }

        Collections.sort(recordDTOS, Comparator.comparingDouble(RecordsDto::getScore).reversed());
        return recordDTOS;
    }


    private boolean isCriminalRulePassed(final String value1, final String value2, final double matching_score) {
        double value1d = Double.parseDouble(value1);
        double value2d = Double.parseDouble(value2) * 100;
        return isCriminalRulePassed(value1d, value2d, matching_score);
    }

    private boolean isCriminalRulePassed(final double value1, final double value2, final double matching_score) {
        final KieSession ruleSession = kieContainer.newKieSession();
        try {
            final CriminalRuleCDO criminalRuleCDO = new CriminalRuleCDO();
            criminalRuleCDO.setScore1(value1);
            criminalRuleCDO.setScore2(value2);
            criminalRuleCDO.setSearchScore(matching_score);
            ruleSession.insert(criminalRuleCDO);
            ruleSession.fireAllRules();

            if (StringUtils.isNoneBlank(criminalRuleCDO.getStatus()) && criminalRuleCDO.getStatus().equalsIgnoreCase("success")) {
                return true;
            }
            return false;
        } finally {
            ruleSession.dispose();
        }
    }
}