package com.ponsun.cms.SearchDetails.Search.api;

import com.ponsun.cms.ReportRecord.ReportRecordDtos;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import com.ponsun.cms.SearchDetails.Search.data.SearchData;
import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;
import com.ponsun.cms.SearchDetails.Search.services.SearchReadPlatformService;
import com.ponsun.cms.SearchDetails.Search.services.SearchWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Search")
@Tag(name = "SearchApiResource")
public class SearchApiResources {

    private final SearchWritePlatformService searchWritePlatformService;
    private final SearchReadPlatformService searchReadPlatformService;

    @PostMapping("/CreateSearchRequest")
    public Response saveSearch(@RequestBody CreateSearchRequest createSearchRequest) {
        Response response = this.searchWritePlatformService.createSearch(createSearchRequest);
        return response;
    }
    @GetMapping("/fetchAllSearchData")
    public List<SearchData> fetchAllSearchData(@RequestParam String fromDate, @RequestParam String toDate) {
        return this.searchReadPlatformService.fetchAllSearchData(fromDate, toDate);
    }
    @GetMapping("/fetchAllSearchDetailsData")
    public List<SearchDetailsData> fetchAllSearchDetailData(@RequestParam String fromDate, @RequestParam String toDate) {
        return this.searchReadPlatformService.fetchAllSearchDetailData(fromDate, toDate);
    }
    @GetMapping("/Search")
    public List<ReportRecordDtos> fetchAllDetailData(@RequestParam String fromDate , @RequestParam String toDate){
        return this.searchReadPlatformService.fetchAllDetailData(fromDate , toDate);}


}
