package com.ponsun.cms.CommonAPI;

import com.ponsun.cms.CommonAPI.service.CommonWriteService;
import com.ponsun.cms.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/DetailSave")
@Tag(name = "SaveDetailsApiResource")
public class DetailsCommonApiResource {
    private final CommonWriteService commonWriteService;

    //    @PostMapping("/CreateDetails")
//    public Response saveCreateDetails(@RequestParam ("DetailsDTOList") String detailsDTOList,
//                                      @RequestParam(value = "files", required = false) MultipartFile[] documentfiles,
//                                      @RequestParam(value = "pathId", required = false)Integer pathId,
//                                      @RequestParam(value = "imgName", required = false)Integer imgName) {
//        return this.commonWriteService.saveDetails(detailsDTOList,documentfiles,pathId,imgName);
//    }
    @PostMapping("/CreateDetails")
    public Response saveCreateDetails(@RequestParam("DetailsDTOList") String detailsDTOList, MultipartFile[] documentfiles, Integer[] pathId, Integer imgName) {
        return this.commonWriteService.saveDetails(detailsDTOList, documentfiles, pathId, imgName);
    }

    @PutMapping("/UpdateDetails")
    public Response updateDetails(@RequestParam("DetailsDTOList") String detailsDTOList, Integer cmsId, Integer euid, MultipartFile[] documentfiles, Integer[] pathId, Integer imgName) {
        return this.commonWriteService.updateDetails(detailsDTOList, cmsId, euid, documentfiles, pathId, imgName);
    }

    @GetMapping("/GetDetails/{cmsId}")
    public DetailsReadDTO getDetails(@PathVariable("cmsId") Integer cmsId) {
        return this.commonWriteService.getDetails(cmsId);
    }
}
