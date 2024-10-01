package com.ponsun.cms.RequestDescription.request;

import lombok.Data;

@Data
public class AbstractRequestDescriptionRequest {
    private Integer id;
    private Integer cmsId;
    private String description;
    private Integer uid;
}
