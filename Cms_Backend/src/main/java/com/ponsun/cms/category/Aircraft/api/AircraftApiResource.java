package com.ponsun.cms.category.Aircraft.api;


import com.ponsun.cms.category.Aircraft.data.AircraftData;
import com.ponsun.cms.category.Aircraft.services.AircraftReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Aircraft")
public class AircraftApiResource {
    private  final AircraftReaPlatformService aircraftReaPlatformService;
    @GetMapping
    public List<AircraftData> fetchAll(String cmsName ){
        return this.aircraftReaPlatformService.fetchAllAircraftData(cmsName);}
}
