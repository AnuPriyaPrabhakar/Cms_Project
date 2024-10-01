package com.ponsun.cms.FilesStorage.request;

import lombok.Data;

@Data
public class AbstractFileStorageRequest {

    private Integer id;
    private Integer documentId;
    private Integer pathId;
    private String documentType;
    private int uid;
    private String dt;
    private String url;
}
