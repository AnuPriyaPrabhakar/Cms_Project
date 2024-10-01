package com.ponsun.cms.allDetails.CombinedServices.api;

import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedReadService;
import com.ponsun.cms.allDetails.CombinedServices.service.DetailsCombinedWriteService;
import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DetailsCombineDTO;
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
@RequestMapping("api/v1/saveDetails")
@Tag(name = "DetailsCombinedApi")
public class DetailsCombinedApi {
    private final DetailsCombinedWriteService detailsCombinedWriteService;
    private final DetailsCombinedReadService detailsCombinedReadService;
    @PostMapping("/saveDetails/{cmsId}")
    public Response saveDetails(@PathVariable Integer cmsId,Integer recordType, @RequestBody List<DetailsCombineDTO> detailsCombineDTOS) {
        return detailsCombinedWriteService.createDetail(cmsId,  detailsCombineDTOS);
    }
    @GetMapping("/{cmsId}/{recordTypeId}")
    public List<DetailsCombineDTO> getDetails(@PathVariable Integer cmsId){
        return this.detailsCombinedReadService.getDetails(cmsId);
    }
}



