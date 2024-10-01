package com.ponsun.cms.RequestDescription.domain;


import com.ponsun.cms.RequestDescription.request.CreateRequestDescriptionRequest;
import com.ponsun.cms.RequestDescription.request.UpdateRequestDescriptionRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_request_for_update_description")
public class RequestDescription extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name="description")
    private String description;

    @Column(name = "uid")
    private Integer uid;

    public static  RequestDescription create(final CreateRequestDescriptionRequest createRequestDescriptionRequest){
        final RequestDescription requestDescription = new RequestDescription();
        requestDescription.setCmsId(createRequestDescriptionRequest.getCmsId());
        requestDescription.setDescription(createRequestDescriptionRequest.getDescription());
        requestDescription.setUid(createRequestDescriptionRequest.getUid());
        requestDescription.setStatus(Status.ACTIVE);
        requestDescription.setCreatedAt(LocalDateTime.now());
        return requestDescription;
    }
    public void update(final UpdateRequestDescriptionRequest updateRequestDescriptionRequest){
        this.setCmsId(updateRequestDescriptionRequest.getCmsId());
        this.setDescription(updateRequestDescriptionRequest.getDescription());
//        this.setUid(updateRequestDescriptionRequest.getUid());
        this.setStatus(Status.ACTIVE);
        this.setUpdatedAt(LocalDateTime.now());
    }
}
