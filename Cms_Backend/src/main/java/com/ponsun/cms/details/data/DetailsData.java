package com.ponsun.cms.details.data;

import lombok.Data;

@Data
public class DetailsData {
    private Integer id;
    private Integer recordTypeId;
    private Integer regulatorListId;
    private Integer regulatorId;
    private Integer display;
    private String sourceLink;
    private String name;
    private String registrationNum;
    private Integer genderId;
    private Integer deadId;
    private Integer uid;
    private Integer euid;
    private String qcViewDt;
    private String qcEditDt;
    private String managerApproveDt;
    private String qcPendingDt;
    private String publishedDt;
    private String managerPendingDt;

    public DetailsData ( final Integer id,final Integer recordTypeId,final Integer regulatorListId,final Integer regulatorId,final Integer display, final String sourceLink,final String name, final String registrationNum,final Integer genderId, final Integer deadId, final Integer uid,final Integer euid,final String qcViewDt,final String qcEditDt,final  String managerApproveDt,final String qcPendingDt,final String publishedDt,final String managerPendingDt){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.regulatorListId=regulatorListId;
        this.regulatorId = regulatorId;
        this.display = display;
        this.sourceLink = sourceLink;
        this.name = name;
        this.registrationNum = registrationNum;
        this.genderId = genderId;
        this.deadId = deadId;
        this.uid = uid;
        this.euid = euid;
        this.qcViewDt = qcViewDt;
        this.qcEditDt = qcEditDt;
        this.managerApproveDt = managerApproveDt;
        this.qcPendingDt = qcPendingDt;
        this.publishedDt = publishedDt;
        this.managerPendingDt = managerPendingDt;

    }
    public static DetailsData newInstance ( final Integer id,final Integer recordTypeId,final Integer regulatorListId,final Integer regulatorId,final Integer display, final String sourceLink,final String name, final String registrationNum,final Integer genderId, final Integer deadId, final Integer uid,final Integer euid,final String qcViewDt,final String qcEditDt,final  String managerApproveDt,final String qcPendingDt,final String publishedDt,final String managerPendingDt) {
        return new DetailsData(id,recordTypeId,regulatorListId,regulatorId,display,sourceLink, name, registrationNum,genderId,  deadId,  uid,euid,qcViewDt,qcEditDt,managerApproveDt,qcPendingDt,publishedDt,managerPendingDt);
    }
}
