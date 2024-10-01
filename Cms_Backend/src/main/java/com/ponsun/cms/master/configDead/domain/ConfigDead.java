package com.ponsun.cms.master.configDead.domain;

import com.ponsun.cms.master.configDead.request.CreateConfigDeadRequest;
import com.ponsun.cms.master.configDead.request.UpdateConfigDeadRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_config_dead")
public class ConfigDead extends BaseEntity {
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

    public static ConfigDead create(final CreateConfigDeadRequest createConfigDeadRequest){
        final ConfigDead configDead = new ConfigDead();
        configDead.setName(createConfigDeadRequest.getName());
        configDead.setUid(createConfigDeadRequest.getUid());
        configDead.onCreate();
        configDead.setStatus(Status.ACTIVE);
        return configDead;
    }
    public void update(UpdateConfigDeadRequest updateConfigDeadRequest){
        this.setName(updateConfigDeadRequest.getName());
        this.setEuid(updateConfigDeadRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateConfigDeadRequest updateConfigDeadRequest){
        this.setEuid(updateConfigDeadRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
