package com.ponsun.cms.IndOrg.relation.domain;

import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relation.request.UpdateRelationRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_relations")
public class Relation extends BaseEntity {
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

    @Column(name = "relativeMasterId")
    private Integer relativeMasterId;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static Relation create(final CreateRelationRequest createRelationRequest){
        final Relation relation = new Relation();
        relation.setRecordTypeId(createRelationRequest.getRecordTypeId());
        relation.setCmsId(createRelationRequest.getCmsId());
        relation.setPositionId(createRelationRequest.getPositionId());
        relation.setRelativeMasterId(createRelationRequest.getRelativeMasterId());
        relation.setRelationship(createRelationRequest.getRelationship());
        relation.setUid(createRelationRequest.getUid());
        relation.onCreate();
        relation.setStatus(Status.ACTIVE);
        return relation;
    }
    public void update(UpdateRelationRequest updateRelationRequest){
        this.setRecordTypeId(updateRelationRequest.getRecordTypeId());
        this.setCmsId(updateRelationRequest.getCmsId());
        this.setPositionId(updateRelationRequest.getPositionId());
        this.setRelativeMasterId(updateRelationRequest.getRelativeMasterId());
        this.setEuid(updateRelationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
    public void deactive(UpdateRelationRequest updateRelationRequest){
        this.setEuid(updateRelationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
