package com.ponsun.cms.regulator.api;

import com.ponsun.cms.regulator.domain.Regulator;
import com.ponsun.cms.regulator.request.CreateRegulatorRequest;
import com.ponsun.cms.regulator.request.UpdateRegulatorRequest;
import com.ponsun.cms.regulator.services.RegulatorReadPlatformService;
import com.ponsun.cms.regulator.services.RegulatorWritePlatformService;
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
@RequestMapping("/api/v1/Regulator")
@Tag(name = "RegulatorApiResource")
public class RegulatorApiResource {
    private final RegulatorWritePlatformService regulatorWritePlatformService;
    private final RegulatorReadPlatformService companiesAddressReadPlatformService;
    @PostMapping("/CreateRegulatorRequest")
    public Response saveAddress(@RequestBody CreateRegulatorRequest regulatorRequest){
        Response response = this.regulatorWritePlatformService.createRegulator(regulatorRequest);
        return response;
    }
    @GetMapping
    public List<Regulator> fetchAll(){ return this.companiesAddressReadPlatformService.fetchAllRegulator();}

    @GetMapping("/{id}")
    public Regulator fetchRegulatorById(@PathVariable(name = "id")Integer id){
        return this.companiesAddressReadPlatformService.fetchRegulatorById(id);
    }


    @PutMapping("/{id}")
    public Response updateRegulator(@PathVariable Integer id, @RequestBody UpdateRegulatorRequest updateRegulatorRequest){
        Response response = this.regulatorWritePlatformService.updateRegulator(id,updateRegulatorRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockRegulator(@PathVariable Integer id){
        Response response = this.regulatorWritePlatformService.blockRegulator(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockRegulator(@PathVariable Integer id){
       Response response = this.regulatorWritePlatformService.unblockRegulator(id);
       return  response;
    }

}
