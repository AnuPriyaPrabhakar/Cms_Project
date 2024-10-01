package com.ponsun.cms.caseDetails.api;


import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.caseDetails.domain.CaseDetails;
import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.request.UpdateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.services.CaseDetailsReadPlatFormService;
import com.ponsun.cms.caseDetails.services.CaseDetailsWritePlatFormService;
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
@RequestMapping("/api/v1/CaseDetails")
@Tag(name = "CaseDetailsApiResources")
public class CaseDetailsApiResources {
    private final CaseDetailsWritePlatFormService caseDetailsWritePlatformService;
    private final CaseDetailsReadPlatFormService caseDetailsReadPlatformService;
    @PostMapping("/CreateCaseDetailsRequest")
    public Response saveCaseDetails(@RequestBody CreateCaseDetailsRequest createCaseDetailsRequest){
        Response response = this.caseDetailsWritePlatformService.createCaseDetails(createCaseDetailsRequest);
        return response;
    }
    @GetMapping
    public List<CaseDetails> fetchAll(){ return this.caseDetailsReadPlatformService.fetchAllCaseDetails();}

    @GetMapping("/{id}")
    public CaseDetails fetchCaseDetailsById(@PathVariable(name = "id")Integer id){
        return this.caseDetailsReadPlatformService.fetchCaseDetailsById(id);
    }
    @GetMapping("/CaseDetailsData/{cmsId}/{recordTypeId}")
    public List<CaseDetailsData> getCaseDetailsData(@PathVariable Integer cmsId){
        return this.caseDetailsWritePlatformService.fetchAllCaseDetailsData(cmsId);
    }
    @PutMapping("/{id}")
    public Response updateCaseDetails(@PathVariable Integer id, @RequestBody UpdateCaseDetailsRequest updateAliasesNameRequest){
        Response response = this.caseDetailsWritePlatformService.updateCaseDetails(id,updateAliasesNameRequest);
        return  response;
    }

    @PutMapping("/deactivate/{cmsId}/{euid}")
    public Response deactivate(@PathVariable Integer cmsId, @PathVariable Integer euid){
        Response response = this.caseDetailsWritePlatformService.deactive(cmsId, euid);
        return  response;
    }


}
