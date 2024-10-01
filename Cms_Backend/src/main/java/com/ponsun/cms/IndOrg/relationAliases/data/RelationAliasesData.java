package com.ponsun.cms.IndOrg.relationAliases.data;

import lombok.Data;

@Data
public class RelationAliasesData {

    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String relationAliasesName;
    private Integer uid;
    private Integer euid;

    public RelationAliasesData (final Integer cmsId ,final Integer recordTypeId , final Integer positionId , final String relationAliasesName , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.relationAliasesName = relationAliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static RelationAliasesData newInstance(final Integer cmsId ,final Integer recordTypeId , final Integer positionId , final String relationAliasesName , final Integer uid , final Integer euid) {
        return new RelationAliasesData(cmsId, recordTypeId, positionId, relationAliasesName, uid, euid);
    }
}
