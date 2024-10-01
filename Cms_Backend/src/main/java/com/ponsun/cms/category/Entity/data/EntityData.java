package com.ponsun.cms.category.Entity.data;

import lombok.Data;

@Data
public class EntityData {
    private Integer cmsId;
    private String userName;
    private String cmsName;
    private String sourceLink;
    private Integer genderId;

    public EntityData(final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        this.cmsId = cmsId;
        this.userName = userName;
        this.cmsName = cmsName;
        this.sourceLink = sourceLink;
        this.genderId = genderId;
    }

    public static EntityData newInstance (final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        return new EntityData(cmsId,userName, cmsName, sourceLink, genderId);
    }
}
