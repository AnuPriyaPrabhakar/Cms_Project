package com.ponsun.cms.company.commondto.api;

import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedReadService;
import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedWriteService;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
import com.ponsun.cms.company.commondto.dto.CompanyCombineDTO;
import com.ponsun.cms.company.commondto.services.CommonDtoReadService;
import com.ponsun.cms.company.commondto.services.CommonDtoWriteService;
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
@RequestMapping("api/v1/saveCompanyDetails")
@Tag(name = "CommonDtoApiResources")
public class CommonDtoApiResources {
    private final CommonDtoReadService commonDtoReadService;
    private final CommonDtoWriteService  commonDtoWriteService;
    @GetMapping("/{cmsId}/{recordTypeId}")
    public List<CompanyCombineDTO> getDetails(@PathVariable Integer cmsId){
        return this.commonDtoReadService.getCompanyDetails(cmsId);
    }
}
