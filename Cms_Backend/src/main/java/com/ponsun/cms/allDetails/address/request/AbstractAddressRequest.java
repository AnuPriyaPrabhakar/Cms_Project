package com.ponsun.cms.allDetails.address.request;

import lombok.Data;

@Data
public class AbstractAddressRequest {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String address;
    private Integer uid;
    private Integer euid;
}
