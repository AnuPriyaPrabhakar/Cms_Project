package com.ponsun.cms.allDetails.aliases.request;

import lombok.Data;

@Data
public class AbstractAliasesRequest {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;
}
