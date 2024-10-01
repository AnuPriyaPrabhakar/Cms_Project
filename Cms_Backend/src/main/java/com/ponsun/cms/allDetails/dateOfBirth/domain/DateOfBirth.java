package com.ponsun.cms.allDetails.dateOfBirth.domain;

import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.request.UpdateDateOfBirthRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_birth_details")
public class DateOfBirth extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "dob")
    private String dob;

    @Column(name = "birthYearAlone")
    private String birthYearAlone;

    @Column(name = "placeOfBirth")
    private String placeOfBirth;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static DateOfBirth create(final CreateDateOfBirthRequest createDateOfBirthRequest){
        final DateOfBirth dateOfBirth = new DateOfBirth();
        dateOfBirth.setId(createDateOfBirthRequest.getId());
        dateOfBirth.setRecordTypeId(createDateOfBirthRequest.getRecordTypeId());
        dateOfBirth.setCmsId(createDateOfBirthRequest.getCmsId());
        dateOfBirth.setDob(createDateOfBirthRequest.getDob());
        dateOfBirth.setBirthYearAlone(createDateOfBirthRequest.getBirthYearAlone());
        dateOfBirth.setPlaceOfBirth(createDateOfBirthRequest.getPlaceOfBirth());
        dateOfBirth.setUid(createDateOfBirthRequest.getUid());
        dateOfBirth.onCreate();
        dateOfBirth.setStatus(Status.ACTIVE);
        return dateOfBirth;
    }
    public void update(UpdateDateOfBirthRequest updateDateOfBirthRequest){
        this.setId(updateDateOfBirthRequest.getId());
        this.setRecordTypeId(updateDateOfBirthRequest.getRecordTypeId());
        this.setCmsId(updateDateOfBirthRequest.getCmsId());
        this.setDob(updateDateOfBirthRequest.getDob());
        this.setBirthYearAlone(updateDateOfBirthRequest.getBirthYearAlone());
        this.setPlaceOfBirth(updateDateOfBirthRequest.getPlaceOfBirth());
        this.setEuid(updateDateOfBirthRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateDateOfBirthRequest updateDateOfBirthRequest){
        this.setEuid(updateDateOfBirthRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
