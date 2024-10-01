package com.ponsun.cms.company.companyDetails.domain;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.company.companyDetails.request.CreateCompanyDetailsRequest;
import com.ponsun.cms.company.companyDetails.request.UpdateCompanyDetailsRequest;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_company_details")
public class CompanyDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name ="cmsId")
    private Integer cmsId;

    @Column(name ="identificationNumberId")
    private Integer identificationNumberId;

    @Column(name ="stateId")
    private Integer stateId;

    @Column(name = "role")
    private String role;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "idDetails")
    private String idDetails;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CompanyDetails create(final CreateCompanyDetailsRequest createBankDetailsRequest){
        final CompanyDetails companyDetails = new CompanyDetails();
        companyDetails.setRecordTypeId(createBankDetailsRequest.getRecordTypeId());
        companyDetails.setCmsId(createBankDetailsRequest.getCmsId());
        companyDetails.setIdentificationNumberId(createBankDetailsRequest.getIdentificationNumberId());
        companyDetails.setStateId(createBankDetailsRequest.getStateId());
        companyDetails.setRole(createBankDetailsRequest.getRole());
        companyDetails.setCompanyName(createBankDetailsRequest.getCompanyName());
        companyDetails.setAddress(createBankDetailsRequest.getAddress());
        companyDetails.setIdDetails(createBankDetailsRequest.getIdDetails());
        companyDetails.setUid(createBankDetailsRequest.getUid());
        companyDetails.onCreate();
        companyDetails.setStatus(Status.ACTIVE);
        return companyDetails;
    }
    public void update(UpdateCompanyDetailsRequest updateBankDetailsRequest){
        this.setRecordTypeId(updateBankDetailsRequest.getRecordTypeId());
        this.setCmsId(updateBankDetailsRequest.getCmsId());
        this.setIdentificationNumberId(updateBankDetailsRequest.getIdentificationNumberId());
        this.setRole(updateBankDetailsRequest.getRole());
        this.setCompanyName(updateBankDetailsRequest.getCompanyName());
        this.setAddress(updateBankDetailsRequest.getAddress());
        this.setIdDetails(updateBankDetailsRequest.getIdDetails());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCountryRegistrationRequest updateCountryRegistrationRequest){
        this.setEuid(updateCountryRegistrationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
