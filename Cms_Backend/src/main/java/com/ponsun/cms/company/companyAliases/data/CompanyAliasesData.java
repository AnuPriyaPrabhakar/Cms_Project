package com.ponsun.cms.company.companyAliases.data;

import lombok.Data;

@Data
public class CompanyAliasesData {
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer companyId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;
    public CompanyAliasesData(final Integer recordTypeId, final Integer cmsId, final Integer companyId, final String aliasesName, Integer uid, final Integer euid) {
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.companyId = companyId;
        this.aliasesName = aliasesName;
        this.uid = uid;
        this.euid = euid;
    }

    public static CompanyAliasesData newInstance(final Integer recordTypeId, final Integer cmsId, final Integer companyId, final String aliasesName, Integer uid, final Integer euid) {
        return new CompanyAliasesData(recordTypeId, cmsId, companyId, aliasesName, uid, euid);
    }
}
