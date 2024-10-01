package com.ponsun.cms.IndOrg.indAliasesName.data;

import lombok.Data;

@Data
public class IndAliasesNameData {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String linIndAliasesName;
    private Integer uid;
    private Integer euid;

    public IndAliasesNameData (final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String linIndAliasesName , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.linIndAliasesName = linIndAliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static IndAliasesNameData newInstance(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String linIndAliasesName , final Integer uid , final Integer euid) {
        return  new IndAliasesNameData(cmsId, recordTypeId, positionId, linIndAliasesName, uid, euid);
    }
}
