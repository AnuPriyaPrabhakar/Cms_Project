package com.ponsun.cms.IndOrg.relationAliases.api;


import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationAliasesDTO;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliases;
import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.services.RelationAliasesReadPlatformService;
import com.ponsun.cms.IndOrg.relationAliases.services.RelationAliasesWritePlatformService;
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
@RequestMapping("/api/v1/RelationAliases")
@Tag(name = "RelationAliasesApiResource")
public class RelationAliasesApiResource {
    private final RelationAliasesWritePlatformService relationAliasesWritePlatformService;
    private final RelationAliasesReadPlatformService relationAliasesReadPlatformService;
    @PostMapping("/CreateRelationAliasesRequest")
    public Response saveRelationAliases(@RequestBody CreateRelationAliasesRequest createRelationAliasesRequest){
        Response response = this.relationAliasesWritePlatformService.createRelationAliases(createRelationAliasesRequest);
        return response;
    }
    @GetMapping
    public List<RelationAliases> fetchAll(){ return this.relationAliasesReadPlatformService.fetchAllRelationAliases();}

    @GetMapping("/{id}")
    public RelationAliases fetchRelationAliasesById(@PathVariable(name = "id")Integer id){
        return this.relationAliasesReadPlatformService.fetchRelationAliasesById(id);
    }


    @PutMapping("/{id}")
    public Response updateRelationAliases(@PathVariable Integer id, @RequestBody UpdateRelationAliasesRequest updateRelationAliasesRequest){
        Response response = this.relationAliasesWritePlatformService.updateRelationAliases(id,updateRelationAliasesRequest);
        return  response;
    }

//    @GetMapping("/RelationAliases/{cmsId}/{recordTypeId}")
//    public List<RelationAliasesDTO> getRelationsAliasesDTO(@PathVariable Integer cmsId, Integer recordTypeId){
//        return this.relationAliasesWritePlatformService.fetchRelationAliasesDTO(cmsId,recordTypeId);
//    }
}
