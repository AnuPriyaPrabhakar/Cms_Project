package com.ponsun.cms.IndOrg.relationAliases.request;

import lombok.Data;

@Data
public class AbstractRelationAliasesRequest {

    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String relationAliasesName;
    private Integer uid;
    private Integer euid;
}
