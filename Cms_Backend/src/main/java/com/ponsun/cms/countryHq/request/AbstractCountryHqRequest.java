package com.ponsun.cms.countryHq.request;

import lombok.Data;

@Data
public class AbstractCountryHqRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
