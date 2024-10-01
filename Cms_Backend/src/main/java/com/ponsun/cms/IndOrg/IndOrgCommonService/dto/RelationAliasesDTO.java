package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RelationAliasesDTO {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String relationAliasesName;
    private Integer uid;
    private Integer euid;
    public RelationAliasesDTO(final Integer cmsId, final Integer recordTypeId, final Integer positionId, final String relationAliasesName, final Integer uid, final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.positionId = positionId;
        this.relationAliasesName = relationAliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static RelationAliasesDTO newInstance(final Integer cmsId, final Integer recordTypeId, final Integer positionId, final String relationAliasesName, final Integer uid, final Integer euid) {
        return new RelationAliasesDTO (cmsId, recordTypeId, positionId, relationAliasesName, uid, euid);
    }
}