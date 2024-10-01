package com.ponsun.cms.managerView.api;


import com.ponsun.cms.managerView.data.ManagerViewGetViewData;
import com.ponsun.cms.managerView.services.ManagerViewGetReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/ManagerViewGet")
public class ManagerViewGetApiResource {
    private  final ManagerViewGetReaPlatformService managerViewGetReaPlatformService;
    @GetMapping
    public List<ManagerViewGetViewData> fetchAll(String cmsName ){
        return this.managerViewGetReaPlatformService.fetchAllManagerViewData(cmsName);}
}
