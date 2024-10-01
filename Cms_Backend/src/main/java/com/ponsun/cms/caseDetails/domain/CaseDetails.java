package com.ponsun.cms.caseDetails.domain;


import com.ponsun.cms.caseDetails.request.CreateCaseDetailsRequest;
import com.ponsun.cms.caseDetails.request.UpdateCaseDetailsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.countryRegistration.request.CreateCountryRegistrationRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_case_details")
public class CaseDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name ="cmsId")
    private Integer cmsId;

    @Column(name = "caseDetails")
    private String caseDetails;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CaseDetails create(final CreateCaseDetailsRequest createCaseDetailsRequest){
        final CaseDetails caseDetails = new CaseDetails();
        caseDetails.setRecordTypeId(createCaseDetailsRequest.getRecordTypeId());
        caseDetails.setCmsId(createCaseDetailsRequest.getCmsId());
        caseDetails.setCaseDetails(createCaseDetailsRequest.getCaseDetails());
        caseDetails.setUid(createCaseDetailsRequest.getUid());
        caseDetails.onCreate();
        caseDetails.setStatus(Status.ACTIVE);
        return caseDetails;
    }
    public void update(UpdateCaseDetailsRequest updateCaseDetailsRequest){
        this.setRecordTypeId(updateCaseDetailsRequest.getRecordTypeId());
        this.setCmsId(updateCaseDetailsRequest.getCmsId());
        this.setCaseDetails(updateCaseDetailsRequest.getCaseDetails());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCountryRegistrationRequest updateCountryRegistrationRequest){
        this.setEuid(updateCountryRegistrationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
