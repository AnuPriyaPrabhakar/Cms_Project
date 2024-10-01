package com.ponsun.cms.IndOrg.detailsAboutRelation.domain;

import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.UpdateDetailsAboutRelationRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_details_about_relation")
public class DetailsAboutRelation extends BaseEntity {
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

    @Column(name = "detailsAboutRelation")
    private String detailsAboutRelation;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static DetailsAboutRelation create(final CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest){
        final DetailsAboutRelation detailsAboutRelation = new DetailsAboutRelation();
        detailsAboutRelation.setRecordTypeId(createDetailsAboutRelationRequest.getRecordTypeId());
        detailsAboutRelation.setCmsId(createDetailsAboutRelationRequest.getCmsId());
        detailsAboutRelation.setPositionId(createDetailsAboutRelationRequest.getPositionId());
        detailsAboutRelation.setDetailsAboutRelation(createDetailsAboutRelationRequest.getDetailsAboutRelation());
        detailsAboutRelation.setUid(createDetailsAboutRelationRequest.getUid());
        detailsAboutRelation.onCreate();
        detailsAboutRelation.setStatus(Status.ACTIVE);
        return detailsAboutRelation;
    }
    public void update(UpdateDetailsAboutRelationRequest updateDetailsAboutRelationRequest){
        this.setRecordTypeId(updateDetailsAboutRelationRequest.getRecordTypeId());
        this.setCmsId(updateDetailsAboutRelationRequest.getCmsId());
        this.setPositionId(updateDetailsAboutRelationRequest.getPositionId());
        this.setDetailsAboutRelation(updateDetailsAboutRelationRequest.getDetailsAboutRelation());
        this.setEuid(updateDetailsAboutRelationRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateDetailsAboutRelationRequest updateDetailsAboutRelationRequest){
        this.setEuid(updateDetailsAboutRelationRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
