package com.ponsun.cms.IndOrg.IndOrgCommonService.api;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.IndOrgCommonDTO;
import com.ponsun.cms.IndOrg.IndOrgCommonService.service.IndOrgCommonReadPlatformService;
import com.ponsun.cms.IndOrg.IndOrgCommonService.service.IndOrgCommonWritePlatformService;
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
@RequestMapping("api/v1/IndOrgCommon")
@Tag(name = "IndOrgCommonApiResource")
public class IndOrgCommonApi {
    private final IndOrgCommonWritePlatformService indOrgCommonWritePlatformService;
    private final IndOrgCommonReadPlatformService indOrgCommonReadPlatformService;
    @PostMapping("/saveIndOrgDetails/{cmsId}")
    public Response saveIndOrgDetails(@PathVariable Integer cmsId, @RequestBody List<IndOrgCommonDTO> indOrgCommonDTOS) {
        return indOrgCommonWritePlatformService.createIndOrgDetails(cmsId, indOrgCommonDTOS);
    }

    @GetMapping("/IndOrgDetails/{cmsId}")
    public List<IndOrgCommonDTO> getIndOrgDetails(@PathVariable("cmsId") Integer cmsId  )
    {
        return this.indOrgCommonReadPlatformService.getIndOrgDetails(cmsId);
    }
}



