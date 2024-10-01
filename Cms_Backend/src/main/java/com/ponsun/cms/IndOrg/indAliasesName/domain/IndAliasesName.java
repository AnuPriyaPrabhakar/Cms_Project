package com.ponsun.cms.IndOrg.indAliasesName.domain;

import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.indAliasesName.request.UpdateIndAliasesNameRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_individual_aliases_name")
public class IndAliasesName extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "positionId")
    private Integer positionId;

    @Column(name = "linIndAliasesName")
    private String linIndAliasesName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static IndAliasesName create(final CreateIndAliasesNameRequest createIndAliasesNameRequest){
        final IndAliasesName IndAliasesName = new IndAliasesName();
        IndAliasesName.setRecordTypeId(createIndAliasesNameRequest.getRecordTypeId());
        IndAliasesName.setCmsId(createIndAliasesNameRequest.getCmsId());
        IndAliasesName.setPositionId(createIndAliasesNameRequest.getPositionId());
        IndAliasesName.setLinIndAliasesName(createIndAliasesNameRequest.getLinIndAliasesName());
        IndAliasesName.setUid(createIndAliasesNameRequest.getUid());
        IndAliasesName.onCreate();
        IndAliasesName.setStatus(Status.ACTIVE);
        return IndAliasesName;
    }
    public void update(UpdateIndAliasesNameRequest updateIndAliasesNameRequest){
        this.setRecordTypeId(updateIndAliasesNameRequest.getRecordTypeId());
        this.setCmsId(updateIndAliasesNameRequest.getCmsId());
        this.setPositionId(updateIndAliasesNameRequest.getPositionId());
        this.setLinIndAliasesName(updateIndAliasesNameRequest.getLinIndAliasesName());
        this.setEuid(updateIndAliasesNameRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateIndAliasesNameRequest updateIndAliasesNameRequest){
        this.setEuid(updateIndAliasesNameRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
