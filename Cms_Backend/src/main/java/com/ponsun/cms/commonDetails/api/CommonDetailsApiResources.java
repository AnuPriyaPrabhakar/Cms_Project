package com.ponsun.cms.commonDetails.api;


import com.ponsun.cms.commonDetails.data.StatusDetailsData;
import com.ponsun.cms.commonDetails.services.CommonDetailsReadService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/CommonDetailsApiResources")
@Tag(name = "CommonDetailsApiResources")

public class CommonDetailsApiResources {

    private final CommonDetailsReadService commonDetailsReadService;

    @GetMapping("/RecordTypeDTO")
    public List<StatusDetailsData> fetchAllRecordTypeDTO(@RequestParam Integer recordTypeId) {
        return this.commonDetailsReadService.fetchAllData(recordTypeId);
    }
//    @GetMapping("/StatusDetailsDTO")
//    public List<StatusDetailsData> fetchAllDetailsDTO() {
//        return this.commonDetailsReadService.fetchAllDetailsDTO();
//    }
}
