package com.ponsun.cms.company.companyAliases.request;

import lombok.Data;

@Data
public class AbstractCompanyAliasesRequest {
    //private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer companyId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;
}
