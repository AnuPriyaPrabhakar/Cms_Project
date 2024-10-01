package com.ponsun.cms.SearchDetails.SearchDetails.request;

import lombok.Data;

@Data
public class AbstractSearchDetailsRequest {
    private Integer id;
    private Integer searchId;
    private Integer cmsId;
    private String name;
    private double searchingScore;
    private Integer typeId;
    private Integer uid;
}
