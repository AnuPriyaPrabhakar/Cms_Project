package com.ponsun.cms.company.companyDetails.request;

import lombok.Data;

@Data
public class AbstractCompanyDetailsRequest {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer identificationNumberId;
    private Integer stateId;
    private String role;
    private String companyName;
    private String address;
    private String idDetails;
    private Integer uid;
    private Integer euid;
}
