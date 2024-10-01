package com.ponsun.cms.IndOrg.detailsAboutRelation.request;

import lombok.Data;

@Data
public class AbstractDetailsAboutRelationRequest {
    private Integer cmsId;
    private Integer recordTypeId;
    private Integer positionId;
    private String detailsAboutRelation;
    private Integer uid;
    private Integer euid;
}
