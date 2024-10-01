package com.ponsun.cms.IndOrg.positions.domain;


import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.request.UpdatePositionsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_position")
public class Positions extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "position")
    private String position;

    @Column(name = "linIndName")
    private String linIndName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static Positions create(final CreatePositionsRequest createPositionsRequest){
        final Positions Positions = new Positions();
        Positions.setRecordTypeId(createPositionsRequest.getRecordTypeId());
        Positions.setCmsId(createPositionsRequest.getCmsId());
        Positions.setPosition(createPositionsRequest.getPosition());
        Positions.setLinIndName(createPositionsRequest.getLinIndName());
        Positions.setUid(createPositionsRequest.getUid());
        Positions.onCreate();
        Positions.setStatus(Status.ACTIVE);
        return Positions;
    }
    public void update(UpdatePositionsRequest updatePositionsRequest){
        this.setRecordTypeId(updatePositionsRequest.getRecordTypeId());
        this.setCmsId(updatePositionsRequest.getCmsId());
        this.setPosition(updatePositionsRequest.getPosition());
        this.setLinIndName(updatePositionsRequest.getLinIndName());
        this.setEuid(updatePositionsRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdatePositionsRequest updatePositionsRequest){
        this.setEuid(updatePositionsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
