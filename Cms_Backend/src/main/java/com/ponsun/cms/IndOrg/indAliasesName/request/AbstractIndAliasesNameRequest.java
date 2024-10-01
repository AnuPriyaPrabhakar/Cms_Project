package com.ponsun.cms.IndOrg.indAliasesName.request;

import lombok.Data;

@Data
public class AbstractIndAliasesNameRequest {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String linIndAliasesName;
    private Integer uid;
    private Integer euid;
}
