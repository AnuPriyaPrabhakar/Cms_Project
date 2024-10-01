package com.ponsun.cms.allDetails.aliases.api;

import com.ponsun.cms.allDetails.aliases.domain.Aliases;
import com.ponsun.cms.allDetails.aliases.request.CreateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.request.UpdateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.services.AliasesReadPlatformService;
import com.ponsun.cms.allDetails.aliases.services.AliasesWritePlatformService;
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
@RequestMapping("/api/v1/Aliases")
@Tag(name ="AliasesApiResource")
public class AliasesApiResource {
    private final AliasesWritePlatformService aliasesWritePlatformService;
    private final AliasesReadPlatformService aliasesReadPlatformService;

    @PostMapping("/CreateAliasesRequest")
    public Response saveAliases(@RequestBody CreateAliasesRequest createAliasesRequest){
        Response response = this.aliasesWritePlatformService.createAliases(createAliasesRequest);
        return  response;
    }

    @GetMapping
    public List<Aliases> fetchAll(){ return this.aliasesReadPlatformService.fetchAllAliases();}

    @GetMapping("/{id}")
    public Aliases fetchAllAliasesById(@PathVariable(name="id")Integer id){
      return this.aliasesReadPlatformService.fetchAliasesById(id);
    }
    @PutMapping("/{id}")
    public Response updateAliases(@PathVariable Integer id, @RequestBody UpdateAliasesRequest updateAliasesRequest){
       Response response = this.aliasesWritePlatformService.updateAliases(id,updateAliasesRequest);
       return  response;
    }

    @PutMapping("/{id}/block")
    public Response blockAliases(@PathVariable Integer id){
        Response response = this.aliasesWritePlatformService.blockAliases(id);
        return  response;
    }
    @PutMapping("/{id}/unblock")
    public Response unblockAliases(@PathVariable Integer id){
        Response response = this.aliasesWritePlatformService.unblockAliases(id);
        return response;
    }
}
