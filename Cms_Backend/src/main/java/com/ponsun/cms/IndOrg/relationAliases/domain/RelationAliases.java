package com.ponsun.cms.IndOrg.relationAliases.domain;



import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.IndOrg.relationAliases.request.UpdateRelationAliasesRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_relation_aliases_name")
public class RelationAliases extends BaseEntity {
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

    @Column(name = "relationAliasesName")
    private String relationAliasesName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static RelationAliases create(final CreateRelationAliasesRequest createRelationAliasesRequest){
        final RelationAliases RelationAliases = new RelationAliases();
        RelationAliases.setRecordTypeId(createRelationAliasesRequest.getRecordTypeId());
        RelationAliases.setCmsId(createRelationAliasesRequest.getCmsId());
        RelationAliases.setPositionId(createRelationAliasesRequest.getPositionId());
        RelationAliases.setRelationAliasesName(createRelationAliasesRequest.getRelationAliasesName());
        RelationAliases.setUid(createRelationAliasesRequest.getUid());
        RelationAliases.onCreate();
        RelationAliases.setStatus(Status.ACTIVE);
        return RelationAliases;
    }
    public void update(UpdateRelationAliasesRequest updateRelationAliasesRequest){
        this.setRecordTypeId(updateRelationAliasesRequest.getRecordTypeId());
        this.setCmsId(updateRelationAliasesRequest.getCmsId());
        this.setPositionId(updateRelationAliasesRequest.getPositionId());
        this.setRelationAliasesName(updateRelationAliasesRequest.getRelationAliasesName());
        this.setEuid(updateRelationAliasesRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateRelationAliasesRequest updateRelationAliasesRequest){
        this.setEuid(updateRelationAliasesRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
