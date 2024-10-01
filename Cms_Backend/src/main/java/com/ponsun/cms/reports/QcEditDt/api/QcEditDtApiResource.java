package com.ponsun.cms.reports.QcEditDt.api;


import com.ponsun.cms.reports.QcEditDt.data.QcEditDtData;
import com.ponsun.cms.reports.QcEditDt.services.QcEditDtWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcEditDt")
public class QcEditDtApiResource {

    private final QcEditDtWritePlatformService qcEditDtWritePlatformService;

    @GetMapping
    public List<QcEditDtData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcEditDtWritePlatformService.fetchAllQcEditDtData(fromDate , toDate);}
}
