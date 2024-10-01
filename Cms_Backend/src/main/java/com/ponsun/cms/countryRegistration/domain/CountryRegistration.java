package com.ponsun.cms.countryRegistration.domain;


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
@Table(name = "cms_country_registration")
public class CountryRegistration extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "countryId")
    private Integer countryId;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "countryHqId")
    private Integer countryHqId;

    @Column(name = "identificationNumberId")
    private Integer identificationNumberId;

    @Column(name = "identificationNum")
    private String identificationNum;

    @Column(name = "identificationDetails")
    private String identificationDetails;

    @Column(name = "contactId")
    private Integer contactId;

    @Column(name = "contactName")
    private String contactName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CountryRegistration create(final CreateCountryRegistrationRequest createCountryRegistrationRequest){
        final CountryRegistration countryRegistration = new CountryRegistration();
        countryRegistration.setCountryId(createCountryRegistrationRequest.getCountryId());
        countryRegistration.setRecordTypeId(createCountryRegistrationRequest.getRecordTypeId());
        countryRegistration.setCmsId(createCountryRegistrationRequest.getCmsId());
        countryRegistration.setCountryHqId(createCountryRegistrationRequest.getCountryHqId());
        countryRegistration.setIdentificationNumberId(createCountryRegistrationRequest.getIdentificationNumberId());
        countryRegistration.setIdentificationNum(createCountryRegistrationRequest.getIdentificationNum());
        countryRegistration.setIdentificationDetails(createCountryRegistrationRequest.getIdentificationDetails());
        countryRegistration.setContactId(createCountryRegistrationRequest.getContactId());
        countryRegistration.setContactName(createCountryRegistrationRequest.getContactName());
        countryRegistration.setUid(createCountryRegistrationRequest.getUid());
        countryRegistration.onCreate();
        countryRegistration.setStatus(Status.ACTIVE);
        return countryRegistration;
    }
    public void update(UpdateCountryRegistrationRequest updateCountryRegistrationRequest){
        this.setCountryId(updateCountryRegistrationRequest.getCountryId());
        this.setRecordTypeId(updateCountryRegistrationRequest.getRecordTypeId());
        this.setCmsId(updateCountryRegistrationRequest.getCmsId());
        this.setCountryHqId(updateCountryRegistrationRequest.getCountryHqId());
        this.setIdentificationNumberId(updateCountryRegistrationRequest.getIdentificationNumberId());
        this.setIdentificationNum(updateCountryRegistrationRequest.getIdentificationNum());
        this.setIdentificationDetails(updateCountryRegistrationRequest.getIdentificationDetails());
        this.setContactId(updateCountryRegistrationRequest.getContactId());
        this.setContactName(updateCountryRegistrationRequest.getContactName());
        this.setEuid(updateCountryRegistrationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCountryRegistrationRequest updateCountryRegistrationRequest){
        this.setEuid(updateCountryRegistrationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
