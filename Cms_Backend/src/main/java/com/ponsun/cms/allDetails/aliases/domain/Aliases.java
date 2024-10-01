package com.ponsun.cms.allDetails.aliases.domain;

import com.ponsun.cms.allDetails.aliases.request.CreateAliasesRequest;
import com.ponsun.cms.allDetails.aliases.request.UpdateAliasesRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="cms_aliases")
public class Aliases extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name ="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="recordTypeId")
    private Integer recordTypeId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name="aliasesName")
    private String aliasesName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static Aliases create(final CreateAliasesRequest createAliasesRequest){
        final Aliases aliases = new  Aliases();
        aliases.setRecordTypeId(createAliasesRequest.getRecordTypeId());
        aliases.setCmsId(createAliasesRequest.getCmsId());
        aliases.setAliasesName(createAliasesRequest.getAliasesName());
        aliases.setUid(createAliasesRequest.getUid());
        aliases.onCreate();
        aliases.setStatus(Status.ACTIVE);
        return aliases;
    }
    public void update(UpdateAliasesRequest updateAliasesRequest){
        this.setRecordTypeId(updateAliasesRequest.getRecordTypeId());
        this.setCmsId(updateAliasesRequest.getCmsId());
        this.setAliasesName(updateAliasesRequest.getAliasesName());
        this.setEuid(updateAliasesRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
    public void deactive(UpdateAliasesRequest updateAliasesRequest){
        this.setStatus(Status.DELETE);
        this.setEuid(updateAliasesRequest.getEuid());
        this.onUpdate();
    }

}
