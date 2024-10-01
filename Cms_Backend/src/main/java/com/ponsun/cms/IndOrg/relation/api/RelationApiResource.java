package com.ponsun.cms.IndOrg.relation.api;



import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.RelationDTO;
import com.ponsun.cms.IndOrg.relation.domain.Relation;
import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relation.request.UpdateRelationRequest;
import com.ponsun.cms.IndOrg.relation.services.RelationReadPlatformService;
import com.ponsun.cms.IndOrg.relation.services.RelationWritePlatformService;
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
@RequestMapping("/api/v1/Relations")
@Tag(name = "RelationsApiResource")
public class RelationApiResource {
    private final RelationWritePlatformService relationsWritePlatformService;
    private final RelationReadPlatformService relationsReadPlatformService;
    @PostMapping("/CreateRelationsRequest")
    public Response saveRelations(@RequestBody CreateRelationRequest createRelationsRequest){
        Response response = this.relationsWritePlatformService.createRelations(createRelationsRequest);
        return response;
    }
    @GetMapping
    public List<Relation> fetchAll(){ return this.relationsReadPlatformService.fetchAllRelations();}

    @GetMapping("/{id}")
    public Relation fetchRelationsById(@PathVariable(name = "id")Integer id){
        return this.relationsReadPlatformService.fetchRelationsById(id);
    }


    @PutMapping("/{id}")
    public Response updateRelations(@PathVariable Integer id, @RequestBody UpdateRelationRequest updateRelationsRequest){
        Response response = this.relationsWritePlatformService.updateRelations(id,updateRelationsRequest);
        return  response;
    }

    @GetMapping("/Relations/{cmsId}/{recordTypeId}")
    public List<RelationDTO> getRelationDTO(@PathVariable Integer cmsId,Integer positionId){
        return this.relationsWritePlatformService.fetchRelationDTO(cmsId,positionId);
    }
}
