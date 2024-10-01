package com.ponsun.cms.caseDetails.request;

import lombok.Data;

@Data
public class AbstractCaseDetailsRequest {

    private Integer recordTypeId;
    private Integer cmsId;
    private String caseDetails;
    private Integer uid;
    private Integer euid;
}
