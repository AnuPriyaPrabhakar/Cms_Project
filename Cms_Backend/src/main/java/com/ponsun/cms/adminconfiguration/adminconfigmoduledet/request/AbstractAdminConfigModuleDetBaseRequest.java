package com.ponsun.cms.adminconfiguration.adminconfigmoduledet.request;

import lombok.Data;

@Data
public abstract class AbstractAdminConfigModuleDetBaseRequest {
    private Integer id;
    private Integer modId;
    private String name;
    private Boolean valid;
    private String url;
    private Integer uid;
    private  Integer euid;
}
