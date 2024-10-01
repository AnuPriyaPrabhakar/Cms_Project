package com.ponsun.cms.master.RecordType.domain;

import com.ponsun.cms.master.RecordType.request.CreateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.request.UpdateRecordTypeRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_config_record_type")
public class RecordType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static RecordType create(final CreateRecordTypeRequest createRecordTypeRequest){
        final RecordType RecordType = new RecordType();
        RecordType.setName(createRecordTypeRequest.getName());
        RecordType.setUid(createRecordTypeRequest.getUid());
        RecordType.onCreate();
        RecordType.setStatus(Status.ACTIVE);
        return RecordType;
    }
    public void update(UpdateRecordTypeRequest updateRecordTypeRequest){
        this.setName(updateRecordTypeRequest.getName());
        this.setEuid(updateRecordTypeRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateRecordTypeRequest updateRecordTypeRequest){
        this.setEuid(updateRecordTypeRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }


}
