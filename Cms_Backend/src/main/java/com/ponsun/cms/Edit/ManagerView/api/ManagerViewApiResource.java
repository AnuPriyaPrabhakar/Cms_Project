package com.ponsun.cms.Edit.ManagerView.api;
import com.ponsun.cms.Edit.ManagerView.Services.ManagerViewReadPlatformService;
import com.ponsun.cms.Edit.ManagerView.data.ManagerViewData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("api/v1/ManagerView")
public class ManagerViewApiResource {
    private  final ManagerViewReadPlatformService managerViewReadPlatformService;

    @GetMapping
    public List<ManagerViewData> fetchAll(@RequestParam String fromDate , @RequestParam String toDate){
        return this.managerViewReadPlatformService.fetchAllManagerViewData(fromDate,toDate);}
}
