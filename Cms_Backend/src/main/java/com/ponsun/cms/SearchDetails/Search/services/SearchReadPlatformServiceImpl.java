package com.ponsun.cms.SearchDetails.Search.services;

import com.ponsun.cms.ReportRecord.ReportRecordDtos;
import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import com.ponsun.cms.SearchDetails.SearchDetails.rowmapper.SearchDetailsRowMapper;
import com.ponsun.cms.SearchDetails.SearchDetails.services.SearchDetailsReadPlatformService;
import com.ponsun.cms.SearchDetails.Search.data.SearchData;
import com.ponsun.cms.SearchDetails.Search.data.SearchDtos;
import com.ponsun.cms.SearchDetails.Search.rowmapper.SearchRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchReadPlatformServiceImpl implements SearchReadPlatformService {

    private final SearchDetailsRowMapper searchDetailsRowMapper;
    private final SearchRowMapper searchRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final SearchDetailsReadPlatformService searchDetailsReadPlatformService;


    @Override
    public List<SearchData> fetchAllSearchData(String fromDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate", fromDate);
        parameters.put("toDate", toDate);
        final SearchRowMapper rowMapper = new SearchRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(a.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;
        final List<SearchData> SearchData = jdbcTemplate.query(Qry, searchRowMapper,
                new Object[]{fromDate, toDate}
        );
        return SearchData;
    }
    @Override
    public List<SearchDetailsData> fetchAllSearchDetailData(String fromDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("fromDate", fromDate);
        parameters.put("toDate", toDate);
        final SearchDetailsRowMapper rowMapper = new SearchDetailsRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE DATE(cs.created_at) BETWEEN ? AND ?";
        Qry = Qry + whereClause;
        final List<SearchDetailsData> searchDetailsData = jdbcTemplate.query(Qry, searchDetailsRowMapper,
                new Object[]{fromDate, toDate}
        );
        return searchDetailsData;
    }
    @Override
    public List<ReportRecordDtos> fetchAllDetailData(String fromDate, String toDate) {
        SearchDtos searchDtosList = new SearchDtos();
        List<ReportRecordDtos> recordDtosList = new ArrayList<>();
        List<SearchData> searchDataList = fetchAllSearchData(fromDate, toDate);
        ModelMapper modelMapper = new ModelMapper();

        for (SearchData searchData : searchDataList) {
            SearchDtos search = new SearchDtos();
            search.setId(searchData.getId());
            search.setName(searchData.getName());
            search.setMatchingScore(searchData.getMatchingScore());
            search.setFromDate(searchData.getFromDate());
            search.setToDate(searchData.getToDate());

            List<SearchDetailsData> searchDetailsData = this.searchDetailsReadPlatformService.fetchAllSearchDataById(searchData.getId());
            search.setSearchDetailsDataList(searchDetailsData);

            recordDtosList.add(ReportRecordDtos.newInstance(search));
        }
        return recordDtosList;
    }


}
