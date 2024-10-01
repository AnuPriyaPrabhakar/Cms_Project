package com.ponsun.cms.regulator.request;

import lombok.Data;

@Data
public class AbstractRegulatorRequest {
    private Integer id;
    private String Name;
    private Integer uid;
    private Integer euid;
}
