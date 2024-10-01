package com.ponsun.cms.IndCaseDetails.domain;


import com.ponsun.cms.IndCaseDetails.request.CreateIndCaseDetailsRequest;
import com.ponsun.cms.IndCaseDetails.request.UpdateIndCaseDetailsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_individual_case_details")
public class IndCaseDetails extends BaseEntity {
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

    public static IndCaseDetails create(final CreateIndCaseDetailsRequest createIndCaseDetailsRequest){
        final IndCaseDetails indCaseDetails = new IndCaseDetails();
        indCaseDetails.setRecordTypeId(createIndCaseDetailsRequest.getRecordTypeId());
        indCaseDetails.setCmsId(createIndCaseDetailsRequest.getCmsId());
        indCaseDetails.setCaseDetails(createIndCaseDetailsRequest.getCaseDetails());
        indCaseDetails.setUid(createIndCaseDetailsRequest.getUid());
        indCaseDetails.onCreate();
        indCaseDetails.setStatus(Status.ACTIVE);
        return indCaseDetails;
    }
    public void update(UpdateIndCaseDetailsRequest updateIndCaseDetailsRequest){
        this.setRecordTypeId(updateIndCaseDetailsRequest.getRecordTypeId());
        this.setCmsId(updateIndCaseDetailsRequest.getCmsId());
        this.setCaseDetails(updateIndCaseDetailsRequest.getCaseDetails());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
