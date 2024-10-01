package com.ponsun.cms.IndPositions.domain;


import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.request.UpdateIndPositionsRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_individual_position")
public class IndPositions extends BaseEntity {
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

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static IndPositions create(final CreateIndPositionsRequest createIndPositionsRequest){
        final IndPositions IndPositions = new IndPositions();
        IndPositions.setRecordTypeId(createIndPositionsRequest.getRecordTypeId());
        IndPositions.setCmsId(createIndPositionsRequest.getCmsId());
        IndPositions.setPosition(createIndPositionsRequest.getPosition());
        IndPositions.setUid(createIndPositionsRequest.getUid());
        IndPositions.onCreate();
        IndPositions.setStatus(Status.ACTIVE);
        return IndPositions;
    }
    public void update(UpdateIndPositionsRequest updateIndPositionsRequest){
        this.setRecordTypeId(updateIndPositionsRequest.getRecordTypeId());
        this.setCmsId(updateIndPositionsRequest.getCmsId());
        this.setPosition(updateIndPositionsRequest.getPosition());
        this.setEuid(updateIndPositionsRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateIndPositionsRequest updateIndPositionsRequest){
        this.setEuid(updateIndPositionsRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
