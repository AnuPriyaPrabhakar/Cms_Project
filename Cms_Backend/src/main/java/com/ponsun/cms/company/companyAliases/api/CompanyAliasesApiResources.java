package com.ponsun.cms.company.companyAliases.api;



import com.ponsun.cms.company.commondto.dto.CompanyAliasesDTO;
import com.ponsun.cms.company.companyAliases.domain.CompanyAliases;
import com.ponsun.cms.company.companyAliases.request.UpdateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.services.CompanyAliasesWriteService;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.services.CompanyAliasesReadService;
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
@RequestMapping("/api/v1/CompanyAliases")
@Tag(name = "CompanyAliasesApiResources")
public class CompanyAliasesApiResources {
    private final CompanyAliasesWriteService companyAliasesWriteService;
    private final CompanyAliasesReadService companyAliasesReadService;
    @PostMapping("/CreateCompanyAliasesRequest")
    public Response saveCompanyAliases(@RequestBody CreateCompanyAliasesRequest createCompanyAliasesRequest){
        Response response = this.companyAliasesWriteService.createCompanyAliases(createCompanyAliasesRequest);
        return response;
    }
    @GetMapping
    public List<CompanyAliases> fetchAll(){ return this.companyAliasesReadService.fetchAllCompanyAliases();}

    @GetMapping("/{id}")
    public CompanyAliases fetchCompanyAliasesById(@PathVariable(name = "id")Integer id){
        return this.companyAliasesReadService.fetchCompanyAliasesById(id);
    }
    @GetMapping("/CompanyAliasesData/{cmsId}")
    public List<CompanyAliasesDTO> getCompanyAliasesData(@PathVariable Integer cmsId , @PathVariable Integer companyId){
        return this.companyAliasesWriteService.fetchAllCompanyAliasesData(cmsId,companyId);
    }
    @PutMapping("/{id}")
    public Response updateCompanyAliases(@PathVariable Integer id, @RequestBody UpdateCompanyAliasesRequest updateCompanyAliasesRequest){
        Response response = this.companyAliasesWriteService.updateCompanyAliases(id,updateCompanyAliasesRequest);
        return  response;
    }

    @PutMapping("/deactivate/{cmsId}/{euid}")
    public Response deactivate(@PathVariable Integer cmsId, @PathVariable Integer euid){
        Response response = this.companyAliasesWriteService.deactive(cmsId, euid);
        return  response;
    }


}
