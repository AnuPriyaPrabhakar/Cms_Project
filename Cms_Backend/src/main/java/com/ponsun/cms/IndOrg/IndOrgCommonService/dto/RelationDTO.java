package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RelationDTO {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private Integer relativeMasterId;
    private String relationship;
    private Integer uid;
    private Integer euid;

    public RelationDTO(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final Integer relativeMasterId ,final String relationship , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.relativeMasterId = relativeMasterId;
        this.relationship  = relationship;
        this.uid = uid;
        this.euid = euid;

    }

    public static RelationDTO newInstance(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final Integer relativeMasterId ,final String relationship , final Integer uid , final Integer euid) {
        return new RelationDTO(cmsId, recordTypeId, positionId, relativeMasterId,relationship, uid, euid);
    }
}
