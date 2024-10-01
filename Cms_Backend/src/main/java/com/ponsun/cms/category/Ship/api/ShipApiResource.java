package com.ponsun.cms.category.Ship.api;


import com.ponsun.cms.category.Ship.data.ShipData;
import com.ponsun.cms.category.Ship.services.ShipReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Ship")
public class ShipApiResource {
    private  final ShipReaPlatformService shipReaPlatformService;
    @GetMapping
    public List<ShipData> fetchAll(String cmsName ){
        return this.shipReaPlatformService.fetchAllShipData(cmsName);}
}
