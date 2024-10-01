package com.ponsun.cms.countryHq.api;


import com.ponsun.cms.countryHq.domain.CountryHq;
import com.ponsun.cms.countryHq.request.CreateCountryHqRequest;
import com.ponsun.cms.countryHq.request.UpdateCountryHqRequest;
import com.ponsun.cms.countryHq.services.CountryHqReadPlatformService;
import com.ponsun.cms.countryHq.services.CountryHqWritePlatformService;
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
@RequestMapping("/api/v1/CountryHq")
@Tag(name = "CountryHqApiResource")
public class CountryHqApiResource {
    private final CountryHqWritePlatformService countryHqWritePlatformService;
    private final CountryHqReadPlatformService countryHqReadPlatformService;
    @PostMapping("/CreateCountryHqRequest")
    public Response saveCountryHq(@RequestBody CreateCountryHqRequest createCountryHqRequest){
        Response response = this.countryHqWritePlatformService.createCountryHq(createCountryHqRequest);
        return response;
    }
    @GetMapping
    public List<CountryHq> fetchAll(){ return this.countryHqReadPlatformService.fetchAllCountryHq();}

    @GetMapping("/{id}")
    public CountryHq fetchCountryHqById(@PathVariable(name = "id")Integer id){
        return this.countryHqReadPlatformService.fetchCountryHqById(id);
    }


    @PutMapping("/{id}")
    public Response updateCountryHq(@PathVariable Integer id, @RequestBody UpdateCountryHqRequest updateAliasesNameRequest){
        Response response = this.countryHqWritePlatformService.updateCountryHq(id,updateAliasesNameRequest);
        return  response;
    }

}
