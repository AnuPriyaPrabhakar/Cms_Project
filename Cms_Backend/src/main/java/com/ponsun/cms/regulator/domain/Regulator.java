package com.ponsun.cms.regulator.domain;

import com.ponsun.cms.regulator.request.CreateRegulatorRequest;
import com.ponsun.cms.regulator.request.UpdateRegulatorRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_config_regulator")
public class Regulator extends BaseEntity {
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

    public static Regulator create(final CreateRegulatorRequest createRegulatorRequest){
        final Regulator companiesAddress = new Regulator();
        companiesAddress.setName(companiesAddress.getName());
        companiesAddress.setUid(companiesAddress.getUid());
        companiesAddress.onCreate();
        companiesAddress.setStatus(Status.ACTIVE);
        return companiesAddress;
    }
    public void update(UpdateRegulatorRequest updateRegulatorRequest){
        this.setName(updateRegulatorRequest.getName());
        this.setEuid(updateRegulatorRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateRegulatorRequest updateRegulatorRequest){
        this.setEuid(updateRegulatorRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
