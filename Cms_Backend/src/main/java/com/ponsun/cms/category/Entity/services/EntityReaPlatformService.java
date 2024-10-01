package com.ponsun.cms.category.Entity.services;


import com.ponsun.cms.category.Entity.data.EntityData;

import java.util.List;

public interface EntityReaPlatformService {
    List<EntityData> fetchAllEntityData(String cmsName);
}
