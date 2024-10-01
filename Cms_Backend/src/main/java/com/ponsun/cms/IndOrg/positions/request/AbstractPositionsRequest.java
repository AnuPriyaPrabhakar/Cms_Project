package com.ponsun.cms.IndOrg.positions.request;

import lombok.Data;

@Data
public class AbstractPositionsRequest {

    private Integer id;
    private Integer cmsId;
    private Integer recordTypeId;
    private String position;
    private String linIndName;
    private Integer uid;
    private Integer euid;

}
