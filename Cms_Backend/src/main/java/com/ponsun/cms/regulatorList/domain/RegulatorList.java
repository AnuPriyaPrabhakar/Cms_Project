package com.ponsun.cms.regulatorList.domain;

import com.ponsun.cms.regulatorList.request.CreateRegulatorListRequest;
import com.ponsun.cms.regulatorList.request.UpdateRegulatorListRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_config_regulator_list")
public class RegulatorList extends BaseEntity {
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

    public static RegulatorList create(final CreateRegulatorListRequest createRegulatorListRequest){
        final RegulatorList regulatorList = new RegulatorList();
        regulatorList.setName(createRegulatorListRequest.getName());
        regulatorList.setUid(createRegulatorListRequest.getUid());
        regulatorList.onCreate();
        regulatorList.setStatus(Status.ACTIVE);
        return regulatorList;
    }
    public void update(UpdateRegulatorListRequest updateRegulatorListRequest){
        this.setName(updateRegulatorListRequest.getName());
        this.setEuid(updateRegulatorListRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateRegulatorListRequest updateRegulatorListRequest){
        this.setEuid(updateRegulatorListRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
