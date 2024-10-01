package com.ponsun.cms.IndOrg.relation.data;

import lombok.Data;

@Data
public class RelationData {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private Integer relativeMasterId;
    private String relationship;
    private Integer uid;
    private Integer euid;

    public RelationData (final Integer cmsId , final Integer recordTypeId , final Integer positionId , final Integer relativeMasterId ,final String relationship, final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.relativeMasterId = relativeMasterId;
        this.relationship = relationship;
        this.uid = uid;
        this.euid = euid;

    }

    public static RelationData newInstance(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final Integer relativeMasterId ,final String relationship,final Integer uid , final Integer euid) {
        return new RelationData(cmsId, recordTypeId, positionId, relativeMasterId ,relationship, uid, euid);
    }

}
