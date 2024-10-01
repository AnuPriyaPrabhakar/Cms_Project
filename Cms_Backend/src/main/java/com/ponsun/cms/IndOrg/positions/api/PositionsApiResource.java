package com.ponsun.cms.IndOrg.positions.api;


import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.PositionsDTO;
import com.ponsun.cms.IndOrg.positions.data.PositionsData;
import com.ponsun.cms.IndOrg.positions.domain.Positions;
import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.request.UpdatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.services.PositionsReadPlatformService;
import com.ponsun.cms.IndOrg.positions.services.PositionsWritePlatformService;
import com.ponsun.cms.countryRegistration.data.CountryRegistrationData;
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
@RequestMapping("/api/v1/Positions")
@Tag(name = "PositionsApiResource")
public class PositionsApiResource {
    private final PositionsWritePlatformService positionsWritePlatformService;
    private final PositionsReadPlatformService positionsReadPlatformService;
    @PostMapping("/CreatePositionsRequest")
    public Response savePositions(@RequestBody CreatePositionsRequest createPositionsRequest){
        Response response = this.positionsWritePlatformService.createPositions(createPositionsRequest);
        return response;
    }
    @GetMapping
    public List<Positions> fetchAll(){ return this.positionsReadPlatformService.fetchAllPositions();}

    @GetMapping("/{id}")
    public Positions fetchPositionsById(@PathVariable(name = "id")Integer id){
        return this.positionsReadPlatformService.fetchPositionsById(id);
    }


    @PutMapping("/{id}")
    public Response updatePositions(@PathVariable Integer id, @RequestBody UpdatePositionsRequest updatePositionsRequest){
        Response response = this.positionsWritePlatformService.updatePositions(id,updatePositionsRequest);
        return  response;
    }

    @GetMapping("/Positions/{cmsId}/{recordTypeId}")
    public List<PositionsDTO> getPositionsDTO(@PathVariable Integer cmsId){
        return this.positionsWritePlatformService.fetchPositionsDTO(cmsId);
    }


    @PutMapping("/{id}/deActivate")
    public Response deActivate(@RequestParam Integer cmsId , @RequestParam Integer euid ){
        Response response = this.positionsWritePlatformService.DeActiveIndOrg(cmsId,euid);
        return  response;
    }
}
