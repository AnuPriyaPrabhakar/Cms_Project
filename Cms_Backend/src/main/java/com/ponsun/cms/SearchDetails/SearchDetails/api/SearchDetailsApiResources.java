package com.ponsun.cms.SearchDetails.SearchDetails.api;


import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.SearchDetails.SearchDetails.services.SearchDetailsWritePlatformService;
import com.ponsun.cms.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/SearchDetails")
@Tag(name = "SearchDetailsApiResource")
public class SearchDetailsApiResources {
    private final SearchDetailsWritePlatformService searchDetailsWritePlatformService;

    @PostMapping("/CreateSearchDetailsRequest")
    public Response createSearchDetails(@RequestBody CreateSearchDetailsRequest createSearchDetailsRequest){
        Response response = this.searchDetailsWritePlatformService.createSearchDetails(createSearchDetailsRequest);
        return response;
    }
}
