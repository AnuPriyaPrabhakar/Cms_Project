package com.ponsun.cms.details.domain;

import com.ponsun.cms.details.request.CreateDetailsRequest;
import com.ponsun.cms.details.request.UpdateDetailsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_details")
public class Details extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "regulatorListId")
    private Integer regulatorListId;

    @Column(name = "regulatorId")
    private Integer regulatorId;

    @Column(name = "display")
    private Integer display;

    @Column(name = "sourceLink")
    private String sourceLink;

    @Column(name = "name")
    private String name;

    @Column(name = "registrationNum")
    private String registrationNum;

    @Column(name = "genderId")
    private Integer genderId;

    @Column(name = "deadId")
    private Integer deadId;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    @Column(name = "qcViewDt")
    private String qcViewDt;

    @Column(name = "qcEditDt")
    private String qcEditDt;

    @Column(name = "managerApproveDt")
    private String managerApproveDt;

    @Column(name = "qcPendingDt")
    private String qcPendingDt;

    @Column(name = "publishedDt")
    private String publishedDt;

    @Column(name = "managerPendingDt")
    private String managerPendingDt;


    public static Details create(final CreateDetailsRequest createDetailsRequest){
        final Details details = new Details();
        details.setId(createDetailsRequest.getId());
        details.setRecordTypeId(createDetailsRequest.getRecordTypeId());
        details.setRegulatorListId(createDetailsRequest.getRegulatorListId());
        details.setRegulatorId(createDetailsRequest.getRegulatorId());
        details.setDisplay(createDetailsRequest.getDisplay());
        details.setSourceLink(createDetailsRequest.getSourceLink());
        details.setName(createDetailsRequest.getName());
        details.setRegistrationNum(createDetailsRequest.getRegistrationNum());
        details.setGenderId(createDetailsRequest.getGenderId());
        details.setDeadId(createDetailsRequest.getDeadId());
        details.setUid(createDetailsRequest.getUid());
        details.onCreate();
        details.setStatus(Status.ACTIVE);
        return details;
    }

    public void qcupdate(final UpdateDetailsRequest updateDetailsRequest){
        this.setQcViewDt(updateDetailsRequest.getQcViewDt());
        this.setQcEditDt(updateDetailsRequest.getQcEditDt());
        this.setManagerApproveDt(updateDetailsRequest.getManagerApproveDt());
        this.setQcPendingDt(updateDetailsRequest.getQcPendingDt());
        this.setPublishedDt(updateDetailsRequest.getPublishedDt());
        this.setManagerPendingDt(updateDetailsRequest.getManagerPendingDt());
        this.onUpdate();
    }
    public void update(UpdateDetailsRequest updateDetailsRequest){
        this.setRecordTypeId(updateDetailsRequest.getRecordTypeId());
        this.setRegulatorListId(updateDetailsRequest.getRegulatorListId());
        this.setRegulatorId(updateDetailsRequest.getRegulatorId());
        this.setDisplay(updateDetailsRequest.getDisplay());
        this.setSourceLink(updateDetailsRequest.getSourceLink());
        this.setName(updateDetailsRequest.getName());
        this.setRegistrationNum(updateDetailsRequest.getRegistrationNum());
        this.setGenderId(updateDetailsRequest.getGenderId());
        this.setDeadId(updateDetailsRequest.getDeadId());
        this.setEuid(updateDetailsRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateDetailsRequest updateDetailsRequest){
        this.setEuid(updateDetailsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
