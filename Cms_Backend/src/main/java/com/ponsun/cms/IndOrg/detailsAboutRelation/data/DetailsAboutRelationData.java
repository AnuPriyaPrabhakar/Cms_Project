package com.ponsun.cms.IndOrg.detailsAboutRelation.data;

import lombok.Data;

@Data
public class DetailsAboutRelationData {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String detailsAboutRelation;
    private Integer uid;
    private Integer euid;

    public DetailsAboutRelationData(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String detailsAboutRelation , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.detailsAboutRelation = detailsAboutRelation;
        this.uid = uid;
        this.euid = euid;

    }

    public static DetailsAboutRelationData newInstance( final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String detailsAboutRelation , final Integer uid , final Integer euid) {
        return new DetailsAboutRelationData( cmsId, recordTypeId, positionId, detailsAboutRelation, uid, euid);
    }

}

