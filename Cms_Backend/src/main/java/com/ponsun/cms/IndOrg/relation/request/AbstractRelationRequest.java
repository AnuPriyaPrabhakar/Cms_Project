package com.ponsun.cms.IndOrg.relation.request;

import lombok.Data;

@Data
public class AbstractRelationRequest {

    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private Integer relativeMasterId;
    private String relationship;
    private Integer uid;
    private Integer euid;
}
