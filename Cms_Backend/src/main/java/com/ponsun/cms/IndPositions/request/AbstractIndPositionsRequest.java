package com.ponsun.cms.IndPositions.request;

import lombok.Data;

@Data
public class AbstractIndPositionsRequest {
    private Integer cmsId;
    private Integer recordTypeId;
    private String position;
    private Integer uid;
    private Integer euid;
}
