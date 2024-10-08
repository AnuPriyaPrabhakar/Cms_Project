package com.ponsun.cms.Edit.Manager.api;

import com.ponsun.cms.Edit.Manager.data.QcManagerData;
import com.ponsun.cms.Edit.Manager.services.QcManagerWritePlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/QcManagerPending")
public class QcManagerApiResource {
    private  final QcManagerWritePlatformService qcManagerWritePlatformService;

    @GetMapping
    public List<QcManagerData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.qcManagerWritePlatformService.fetchAllQcManagerData(fromDate,toDate);}
}
