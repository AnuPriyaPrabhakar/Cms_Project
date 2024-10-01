package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class IndAliasesNameDTO {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String linIndAliasesName;
    private Integer uid;
    private Integer euid;

    public IndAliasesNameDTO (final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String linIndAliasesName , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.linIndAliasesName = linIndAliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static IndAliasesNameDTO newInstance(final Integer cmsId , final Integer recordTypeId , final Integer positionId , final String linIndAliasesName , final Integer uid , final Integer euid) {
        return  new IndAliasesNameDTO(cmsId, recordTypeId, positionId, linIndAliasesName, uid, euid);
    }
}
