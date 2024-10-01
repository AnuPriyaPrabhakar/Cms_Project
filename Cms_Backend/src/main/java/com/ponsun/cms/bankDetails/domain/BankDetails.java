package com.ponsun.cms.bankDetails.domain;


import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.request.UpdateBankDetailsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.countryRegistration.request.UpdateCountryRegistrationRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_bank_details")
public class BankDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name ="cmsId")
    private Integer cmsId;

    @Column(name ="bankId")
    private Integer bankId;

    @Column(name = "acc_no")
    private String acc_no;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static BankDetails create(final CreateBankDetailsRequest createBankDetailsRequest){
        final BankDetails bankDetails = new BankDetails();
        bankDetails.setRecordTypeId(createBankDetailsRequest.getRecordTypeId());
        bankDetails.setCmsId(createBankDetailsRequest.getCmsId());
        bankDetails.setBankId(createBankDetailsRequest.getBankId());
        bankDetails.setAcc_no(createBankDetailsRequest.getAcc_no());
        bankDetails.setName(createBankDetailsRequest.getName());
        bankDetails.setUid(createBankDetailsRequest.getUid());
        bankDetails.onCreate();
        bankDetails.setStatus(Status.ACTIVE);
        return bankDetails;
    }
    public void update(UpdateBankDetailsRequest updateBankDetailsRequest){
        this.setRecordTypeId(updateBankDetailsRequest.getRecordTypeId());
        this.setCmsId(updateBankDetailsRequest.getCmsId());
        this.setBankId(updateBankDetailsRequest.getBankId());
        this.setAcc_no(updateBankDetailsRequest.getAcc_no());
        this.setName(updateBankDetailsRequest.getName());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCountryRegistrationRequest updateCountryRegistrationRequest){
        this.setEuid(updateCountryRegistrationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
