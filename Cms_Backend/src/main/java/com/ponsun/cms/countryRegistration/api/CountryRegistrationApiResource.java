package com.ponsun.cms.countryRegistration.api;


import com.ponsun.cms.caseDetails.data.CaseDetailsData;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
import com.ponsun.cms.countryRegistration.domain.CountryRegistration;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.services.CountryRegistrationReadPlatformService;
import com.ponsun.cms.countryRegistration.services.CountryRegistrationWritePlatformService;
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
@RequestMapping("/api/v1/CountryRegistration")
@Tag(name = "CountryRegistrationApiResource")
public class CountryRegistrationApiResource {
    private final CountryRegistrationWritePlatformService countryRegistrationWritePlatformService;
    private final CountryRegistrationReadPlatformService countryRegistrationReadPlatformService;
    @PostMapping("/CreateCountryRegistrationRequest")
    public Response saveCountryRegistration(@RequestBody CreateCountryRegistrationRequest createCountryRegistrationRequest){
        Response response = this.countryRegistrationWritePlatformService.createCountryRegistration(createCountryRegistrationRequest);
        return response;
    }
    @GetMapping
    public List<CountryRegistration> fetchAll(){ return this.countryRegistrationReadPlatformService.fetchAllCountryRegistration();}

    @GetMapping("/{id}")
    public CountryRegistration fetchCountryRegistrationById(@PathVariable(name = "id")Integer id){
        return this.countryRegistrationReadPlatformService.fetchCountryRegistrationById(id);
    }


    @PutMapping("/{id}")
    public Response updateCountryRegistration(@PathVariable Integer id, @RequestBody UpdateCountryRegistrationRequest updateAliasesNameRequest){
        Response response = this.countryRegistrationWritePlatformService.updateCountryRegistration(id,updateAliasesNameRequest);
        return  response;
    }

    @GetMapping("/CountryRegistrationData/{cmsId}/{recordTypeId}")
    public List<CountryRegistrationData> getCountryRegistration(@PathVariable Integer cmsId){
        return this.countryRegistrationWritePlatformService.fetchAllCountryRegistrationData(cmsId);
    }


    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer cmsId, @RequestParam Integer euid){
        Response response = this.countryRegistrationWritePlatformService.deactive(cmsId,euid);
        return  response;
    }

}
