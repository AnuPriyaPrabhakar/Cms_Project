package com.ponsun.cms.SearchDetails.Search.request;

import lombok.Data;

@Data
public class AbstractSearchRequest {
    private Integer id;
    private String name;
    private double matchingScore;
}
