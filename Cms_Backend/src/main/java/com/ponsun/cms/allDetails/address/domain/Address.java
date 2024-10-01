package com.ponsun.cms.allDetails.address.domain;

import com.ponsun.cms.allDetails.address.request.CreateAddressRequest;
import com.ponsun.cms.allDetails.address.request.UpdateAddressRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_address")
public class Address extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="recordTypeId")
    private Integer recordTypeId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "address")
    private String address;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static Address create(final CreateAddressRequest createAddressRequest){
        final Address companiesAddress = new Address();
        companiesAddress.setRecordTypeId(createAddressRequest.getRecordTypeId());
        companiesAddress.setCmsId(createAddressRequest.getCmsId());
        companiesAddress.setAddress(createAddressRequest.getAddress());
        companiesAddress.setUid(createAddressRequest.getUid());
        companiesAddress.onCreate();
        companiesAddress.setStatus(Status.ACTIVE);
        return companiesAddress;
    }
    public void update(UpdateAddressRequest updateAddressRequest){
        this.setRecordTypeId(updateAddressRequest.getRecordTypeId());
        this.setCmsId(updateAddressRequest.getCmsId());
        this.setAddress(updateAddressRequest.getAddress());
        this.setEuid(updateAddressRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateAddressRequest updateAddressRequest){
        this.setEuid(updateAddressRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
