package com.ponsun.cms.regulatorList.request;

import lombok.Data;

@Data
public class AbstractRegulatorListRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
