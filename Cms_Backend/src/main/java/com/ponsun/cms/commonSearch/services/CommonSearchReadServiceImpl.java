package com.ponsun.cms.commonSearch.services;

import com.ponsun.cms.algorithm.dto.ScoreCalculate;
import com.ponsun.cms.commonDetails.data.StatusDetailsData;
import com.ponsun.cms.commonDetails.rowmapper.StatusDetailsDTORowMapper;
import com.ponsun.cms.commonDetails.services.CommonDetailsReadService;
import com.ponsun.cms.commonSearch.data.RecordsDto;
import com.ponsun.cms.commonSearch.data.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommonSearchReadServiceImpl implements CommonSearchReadService {

    private final ScoreCalculate scoreCalculate;
    final private CommonDetailsReadService commonDetailsReadService;

    @Override
    @Transactional
    public List<RecordsDto> getRecords(SearchDto searchDto) {
        try {
            final StatusDetailsDTORowMapper rowMapper = new StatusDetailsDTORowMapper();
            String name = searchDto.getName();
            Double matching_score = searchDto.getMatching_score();
            Integer recordTypeId = searchDto.getRecordTypeId();
            final List<StatusDetailsData> statusDetailsData = this.commonDetailsReadService.fetchAllData(recordTypeId);
            List<RecordsDto> recordDTOList = this.scoreCalculate.calculateScore(searchDto, statusDetailsData);
            System.out.println(recordDTOList);
            return recordDTOList;
        } catch (DataAccessException e) {
            System.err.println("Error getTotalRecordsCount: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}