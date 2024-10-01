package com.ponsun.cms.company.companyDetails.api;


import com.ponsun.cms.company.commondto.dto.CompanyDetailsDTO;
import com.ponsun.cms.company.companyDetails.domain.CompanyDetails;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.request.UpdateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.services.CompanyDetailsReadPlatFormService;
import com.ponsun.cms.company.companyDetails.services.CompanyDetailsWritePlatFormService;
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
@RequestMapping("/api/v1/CompanyDetails")
@Tag(name = "CompanyDetailsApiResources")
public class CompanyDetailsApiResources {
    private final CompanyDetailsWritePlatFormService companyDetailsWritePlatformService;
    private final CompanyDetailsReadPlatFormService companyDetailsReadPlatformService;
    @PostMapping("/CreateCompanyDetailsRequest")
    public Response saveCompanyDetails(@RequestBody CreateCompanyDetailsRequest createCompanyDetailsRequest){
        Response response = this.companyDetailsWritePlatformService.createCompanyDetails(createCompanyDetailsRequest);
        return response;
    }
    @GetMapping
    public List<CompanyDetails> fetchAll(){ return this.companyDetailsReadPlatformService.fetchAllCompanyDetails();}

    @GetMapping("/{id}")
    public CompanyDetails fetchCompanyDetailsById(@PathVariable(name = "id")Integer id){
        return this.companyDetailsReadPlatformService.fetchCompanyDetailsById(id);
    }
    @GetMapping("/CompanyDetailsData/{cmsId}/{recordTypeId}")
    public List<CompanyDetailsDTO> getCompanyDetailsData(@PathVariable Integer cmsId){
        return this.companyDetailsWritePlatformService.fetchAllCompanyDetailsData(cmsId);
    }
    @PutMapping("/{id}")
    public Response updateCompanyDetails(@PathVariable Integer id, @RequestBody UpdateCompanyDetailsRequest updateCompanyDetailsRequest){
        Response response = this.companyDetailsWritePlatformService.updateCompanyDetails(id,updateCompanyDetailsRequest);
        return  response;
    }

    @PutMapping("/deactivate/{cmsId}/{euid}")
    public Response deactivate(@PathVariable Integer cmsId, @PathVariable Integer euid){
        Response response = this.companyDetailsWritePlatformService.deActivate(cmsId, euid);
        return  response;
    }


}
