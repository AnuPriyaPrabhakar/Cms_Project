package com.ponsun.cms.IndOrg.detailsAboutRelation.api;

import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.UpdateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.services.DetailsAboutRelationReadPlatformService;
import com.ponsun.cms.IndOrg.detailsAboutRelation.services.DetailsAboutRelationWritePlatformService;
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
@RequestMapping("/api/v1/DetailsAboutRelation")
@Tag(name = "DetailsAboutRelationApiResource")
public class DetailsAboutRelationApiResource {
    private final DetailsAboutRelationWritePlatformService detailsAboutRelationWritePlatformService;
    private final DetailsAboutRelationReadPlatformService detailsAboutRelationReadPlatformService;
    @PostMapping("/CreateDetailsAboutRelationRequest")
    public Response saveDetailsAboutRelation(@RequestBody CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest){
        Response response = this.detailsAboutRelationWritePlatformService.createDetailsAboutRelation(createDetailsAboutRelationRequest);
        return response;
    }
    @GetMapping
    public List<DetailsAboutRelation> fetchAll(){ return this.detailsAboutRelationReadPlatformService.fetchAllDetailsAboutRelation();}

    @GetMapping("/{id}")
    public DetailsAboutRelation fetchDetailsAboutRelationById(@PathVariable(name = "id")Integer id){
        return this.detailsAboutRelationReadPlatformService.fetchDetailsAboutRelationById(id);
    }


    @PutMapping("/{id}")
    public Response updateDetailsAboutRelation(@PathVariable Integer id, @RequestBody UpdateDetailsAboutRelationRequest updateDetailsAboutRelationRequest){
        Response response = this.detailsAboutRelationWritePlatformService.updateDetailsAboutRelation(id,updateDetailsAboutRelationRequest);
        return  response;
    }

//    @GetMapping("/DetailsAboutRelation/{cmsId}/{recordTypeId}")
//    public List<DetailsAboutRelationDTO> getDetailsAboutRelationDTO(@PathVariable Integer cmsId, Integer recordType){
//        return this.DetailsAboutRelationWritePlatformService.fetchDetailsAboutRelationDTO(cmsId,recordType);
//    }
}
