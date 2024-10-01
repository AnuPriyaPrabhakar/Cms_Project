package com.ponsun.cms.regulatorList.api;

import com.ponsun.cms.regulatorList.domain.RegulatorList;
import com.ponsun.cms.regulatorList.request.CreateRegulatorListRequest;
import com.ponsun.cms.regulatorList.request.UpdateRegulatorListRequest;
import com.ponsun.cms.regulatorList.services.RegulatorListReadPlatformService;
import com.ponsun.cms.regulatorList.services.RegulatorListWritePlatformService;
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
@RequestMapping("/api/v1/RegulatorList")
@Tag(name = "RegulatorListApiResource")
public class RegulatorListApiResource {
    private final RegulatorListWritePlatformService regulatorListWritePlatformService;
    private final RegulatorListReadPlatformService regulatorListReadPlatformService;
    @PostMapping("/CreateRegulatorListRequest")
    public Response saveAddress(@RequestBody CreateRegulatorListRequest createRegulatorListRequest){
        Response response = this.regulatorListWritePlatformService.createRegulatorList(createRegulatorListRequest);
        return response;
    }
    @GetMapping
    public List<RegulatorList> fetchAll(){ return this.regulatorListReadPlatformService.fetchAllRegulatorList();}

    @GetMapping("/{id}")
    public RegulatorList fetchRegulatorListById(@PathVariable(name = "id")Integer id){
        return this.regulatorListReadPlatformService.fetchRegulatorListById(id);
    }

    @PutMapping("/{id}")
    public Response updateRegulatorList(@PathVariable Integer id, @RequestBody UpdateRegulatorListRequest updateRegulatorListRequest){
        Response response = this.regulatorListWritePlatformService.updateRegulatorList(id,updateRegulatorListRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockRegulatorList(@PathVariable Integer id){
        Response response = this.regulatorListWritePlatformService.blockRegulatorList(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockRegulatorList(@PathVariable Integer id){
       Response response = this.regulatorListWritePlatformService.unblockRegulatorList(id);
       return  response;
    }
}
