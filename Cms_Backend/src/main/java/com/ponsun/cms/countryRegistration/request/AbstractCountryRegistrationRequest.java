package com.ponsun.cms.countryRegistration.request;

import lombok.Data;

@Data
public class AbstractCountryRegistrationRequest {
    private Integer id;
    private Integer countryId;
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer countryHqId;
    private Integer identificationNumberId;
    private String identificationNum;
    private String identificationDetails;
    private Integer contactId;
    private String contactName;
    private String status;
    private Integer uid;
    private Integer euid;
}
