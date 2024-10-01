package com.ponsun.cms.IndCaseDetails.request;

import lombok.Data;

@Data
public class AbstractIndCaseDetailsRequest {

    private Integer recordTypeId;
    private Integer cmsId;
    private String caseDetails;
    private Integer uid;
    private Integer euid;
}
