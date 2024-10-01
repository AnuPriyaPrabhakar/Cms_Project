package com.ponsun.cms.FilesStorage.domain;

import com.ponsun.cms.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_document")

public class FileStorage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "documentId")
    private Integer documentId;

    @Column(name = "pathId")
    private Integer pathId;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "url")
    private String url;

    public static FileStorage create(final CreateFileStorageRequest createFileStorageRequest){
        final FileStorage fileStorage = new FileStorage();

       fileStorage.setDocumentId(createFileStorageRequest.getDocumentId());
       fileStorage.setUrl(createFileStorageRequest.getUrl());
       fileStorage.setPathId(createFileStorageRequest.getPathId());
       fileStorage.setDocumentType(createFileStorageRequest.getDocumentType());
       fileStorage.setStatus(Status.ACTIVE);
        return fileStorage;
    }


}
