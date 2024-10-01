package com.ponsun.cms.details.api;

import com.ponsun.cms.details.domain.Details;
import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.details.services.DetailsReadPlatformService;
import com.ponsun.cms.details.services.DetailsWritePlatformService;
import com.ponsun.cms.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/Details")
@Tag(name = "DetailsApiResource")
public class DetailsApiResource {
    private final DetailsWritePlatformService detailsWritePlatformService;
    private final DetailsReadPlatformService detailsReadPlatformService;
    @PostMapping("/CreateDetailsRequest")
    public Response saveDetails(@RequestBody CreateDetailsRequest createDetailsRequest){
        Response response = this.detailsWritePlatformService.createDetails(createDetailsRequest);
        return response;
    }
    @GetMapping
    public List<Details> fetchAll(){ return this.detailsReadPlatformService.fetchAllDetails();}

    @GetMapping("/{id}")
    public Details fetchDetailsById(@PathVariable(name = "id")Integer id ){
        return this.detailsReadPlatformService.fetchDetailsById(id);
    }


    @PutMapping("/{id}")
    public Response updateDetails(@PathVariable Integer id, @RequestBody UpdateDetailsRequest updateAliasesNameRequest){
        Response response = this.detailsWritePlatformService.updateDetails(id,updateAliasesNameRequest);
        return  response;
    }

    @PostMapping("/CreateAndUpdateDetailsRequest")
    public Response saveAndUpdateDetails(@RequestBody CreateDetailsRequest createDetailsRequest){
        Response response = this.detailsWritePlatformService.createAndUpdateDetails(createDetailsRequest);
        return response;
    }
}
