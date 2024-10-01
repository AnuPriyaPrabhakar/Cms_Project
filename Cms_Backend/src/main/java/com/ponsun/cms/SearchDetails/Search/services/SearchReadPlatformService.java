package com.ponsun.cms.SearchDetails.Search.services;

import com.ponsun.cms.ReportRecord.ReportRecordDtos;
import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import com.ponsun.cms.SearchDetails.Search.data.SearchData;

import java.util.List;

public interface SearchReadPlatformService {
    List<SearchData> fetchAllSearchData(String fromDate, String toDate);
    List<SearchDetailsData> fetchAllSearchDetailData(String fromDate, String toDate);
    List<ReportRecordDtos>fetchAllDetailData(String fromDate, String toDate);

}
