package com.ponsun.cms.IndCaseDetails.api;


import com.ponsun.cms.IndCaseDetails.data.IndCaseDetailsData;
import com.ponsun.cms.IndCaseDetails.domain.IndCaseDetails;
import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.request.UpdateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.services.IndCaseDetailsReadPlatFormService;
import com.ponsun.cms.IndCaseDetails.services.IndCaseDetailsWritePlatFormService;
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
    @RequestMapping("/api/v1/IndCaseDetails")
@Tag(name = "IndCaseDetailsApiResources")
public class IndCaseDetailsApiResources {
    private final IndCaseDetailsWritePlatFormService indCaseDetailsWritePlatformService;
    private final IndCaseDetailsReadPlatFormService indCaseDetailsReadPlatformService;
    @PostMapping("/CreateCaseDetailsRequest")
    public Response saveCaseDetails(@RequestBody CreateIndCaseDetailsRequest createIndCaseDetailsRequest){
            Response response = this.indCaseDetailsWritePlatformService.createIndCaseDetails(createIndCaseDetailsRequest);
        return response;
    }
    @GetMapping
    public List<IndCaseDetails> fetchAll(){ return this.indCaseDetailsReadPlatformService.fetchAllCaseDetails();}

    @GetMapping("/{id}")
    public IndCaseDetails fetchCaseDetailsById(@PathVariable(name = "id")Integer id){
        return this.indCaseDetailsReadPlatformService.fetchCaseDetailsById(id);
    }
    @GetMapping("/CaseDetailsData/{cmsId}/{recordTypeId}")
    public List<IndCaseDetailsData> getCaseDetailsData(@PathVariable Integer cmsId){
        return this.indCaseDetailsWritePlatformService.fetchAllCaseDetailsData(cmsId);
    }
    @PutMapping("/{id}")
    public Response updateCaseDetails(@PathVariable Integer id, @RequestBody UpdateIndCaseDetailsRequest updateAliasesNameRequest){
        Response response = this.indCaseDetailsWritePlatformService.updateIndCaseDetails(id,updateAliasesNameRequest);
        return  response;
    }

    @PutMapping("/deactivate/{cmsId}/{euid}")
    public Response deactivate(@PathVariable Integer cmsId, @PathVariable Integer euid){
        Response response = this.indCaseDetailsWritePlatformService.deactive(cmsId, euid);
        return  response;
    }


}
