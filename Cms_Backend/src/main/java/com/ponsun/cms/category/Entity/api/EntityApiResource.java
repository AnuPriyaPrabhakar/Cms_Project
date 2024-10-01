package com.ponsun.cms.category.Entity.api;

import com.ponsun.cms.category.Entity.data.EntityData;
import com.ponsun.cms.category.Entity.services.EntityReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Entity")
public class EntityApiResource {
    private  final EntityReaPlatformService entityReaPlatformService;
    @GetMapping
    public List<EntityData> fetchAll(String cmsName ){
        return this.entityReaPlatformService.fetchAllEntityData(cmsName);}
}
