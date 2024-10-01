package com.ponsun.cms.IndOrg.indAliasesName.api;



import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndAliasesNameDTO;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesName;
import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.request.UpdateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.services.IndAliasesNameReadPlatformService;
import com.ponsun.cms.IndOrg.indAliasesName.services.IndAliasesNameWritePlatformService;
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
@RequestMapping("/api/v1/IndAliasesName")
@Tag(name = "IndAliasesNameApiResource")
public class IndAliasesNameApiResource {
    private final IndAliasesNameWritePlatformService indAliasesNameWritePlatformService;
    private final IndAliasesNameReadPlatformService indAliasesNameReadPlatformService;
    @PostMapping("/CreateIndAliasesNameRequest")
    public Response saveIndAliasesName(@RequestBody CreateIndAliasesNameRequest createIndAliasesNameRequest){
        Response response = this.indAliasesNameWritePlatformService.createIndAliasesName(createIndAliasesNameRequest);
        return response;
    }
    @GetMapping
    public List<IndAliasesName> fetchAll(){ return this.indAliasesNameReadPlatformService.fetchAllIndAliasesName();}

    @GetMapping("/{id}")
    public IndAliasesName fetchIndAliasesNameById(@PathVariable(name = "id")Integer id){
        return this.indAliasesNameReadPlatformService.fetchIndAliasesNameById(id);
    }


    @PutMapping("/{id}")
    public Response updateIndAliasesName(@PathVariable Integer id, @RequestBody UpdateIndAliasesNameRequest updateIndAliasesNameRequest){
        Response response = this.indAliasesNameWritePlatformService.updateIndAliasesName(id,updateIndAliasesNameRequest);
        return  response;
    }

//    @GetMapping("/IndAliasesName/{cmsId}/{recordTypeId}")
//    public List<IndAliasesNameDTO> getIndAliasesNameDTO(@PathVariable Integer cmsId, Integer recordType){
//        return this.indAliasesNameWritePlatformService.fetchIndAliasesNameDTO(cmsId,recordType);
//    }
}
