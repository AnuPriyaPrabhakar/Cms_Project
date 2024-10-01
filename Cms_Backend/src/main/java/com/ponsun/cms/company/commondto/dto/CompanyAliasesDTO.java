package com.ponsun.cms.company.commondto.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CompanyAliasesDTO {
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer companyId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;
    public CompanyAliasesDTO(final Integer recordTypeId, final Integer cmsId, final Integer companyId, final String aliasesName, Integer uid, final Integer euid) {
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.companyId = companyId;
        this.aliasesName = aliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static CompanyAliasesDTO newInstance(final Integer recordTypeId, final Integer cmsId, final Integer companyId, final String aliasesName, Integer uid, final Integer euid) {
        return new CompanyAliasesDTO(recordTypeId, cmsId, companyId, aliasesName, uid, euid);
    }
}
