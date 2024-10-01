package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class DetailsAboutRelationDTO {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String detailsAboutRelation;
    private Integer uid;
    private Integer euid;

    public DetailsAboutRelationDTO(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String detailsAboutRelation , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.detailsAboutRelation = detailsAboutRelation;
        this.uid = uid;
        this.euid = euid;

    }

    public static DetailsAboutRelationDTO newInstance(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String detailsAboutRelation , final Integer uid , final Integer euid) {
        return new DetailsAboutRelationDTO (cmsId, recordTypeId, positionId, detailsAboutRelation, uid, euid);
    }
}
