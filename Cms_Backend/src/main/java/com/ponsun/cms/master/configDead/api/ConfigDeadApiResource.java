package com.ponsun.cms.master.configDead.api;

import com.ponsun.cms.master.configDead.domain.ConfigDead;
import com.ponsun.cms.master.configDead.request.CreateConfigDeadRequest;
import com.ponsun.cms.master.configDead.request.UpdateConfigDeadRequest;
import com.ponsun.cms.master.configDead.services.ConfigDeadReadPlatformService;
import com.ponsun.cms.master.configDead.services.ConfigDeadWritePlatformService;
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
@RequestMapping("/api/v1/ConfigDead")
@Tag(name = "ConfigDeadApiResource")
public class ConfigDeadApiResource {
    private final ConfigDeadWritePlatformService configDeadWritePlatformService;
    private final ConfigDeadReadPlatformService configDeadReadPlatformService;
    @PostMapping("/CreateConfigDeadRequest")
    public Response saveConfigDead(@RequestBody CreateConfigDeadRequest createConfigDeadRequest){
        Response response = this.configDeadWritePlatformService.createConfigDead(createConfigDeadRequest);
        return response;
    }
    @GetMapping
    public List<ConfigDead> fetchAll(){ return this.configDeadReadPlatformService.fetchAllConfigDead();}

    @GetMapping("/{id}")
    public ConfigDead fetchConfigDeadById(@PathVariable(name = "id")Integer id){
        return this.configDeadReadPlatformService.fetchConfigDeadById(id);
    }


    @PutMapping("/{id}")
    public Response updateConfigDead(@PathVariable Integer id, @RequestBody UpdateConfigDeadRequest updateAliasesNameRequest){
        Response response = this.configDeadWritePlatformService.updateConfigDead(id,updateAliasesNameRequest);
        return  response;
    }
    @PutMapping("/{id}/block")
    public Response blockConfigDead(@PathVariable Integer id){
        Response response = this.configDeadWritePlatformService.blockConfigDead(id);
        return response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockConfigDead(@PathVariable Integer id){
       Response response = this.configDeadWritePlatformService.unblockConfigDead(id);
       return  response;
    }
}
