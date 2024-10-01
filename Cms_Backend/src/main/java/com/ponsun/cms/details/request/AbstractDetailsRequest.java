package com.ponsun.cms.details.request;

import lombok.Data;

@Data
public class AbstractDetailsRequest {
    private Integer id;
    private Integer recordTypeId;
    private Integer regulatorListId;
    private Integer regulatorId;
    private Integer display;
    private String  sourceLink;
    private String  name;
    private String  registrationNum;
    private Integer genderId;
    private Integer deadId;
    private Integer uid;
    private Integer euid;
    private String  qcViewDt;
    private String  qcEditDt;
    private String  managerApproveDt;
    private String  qcPendingDt;
    private String  publishedDt;
    private String  managerPendingDt;
}
