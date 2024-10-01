package com.ponsun.cms.allDetails.dateOfBirth.request;

import lombok.Data;

@Data
public class AbstractDateOfBirthRequest {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String dob;
    private String birthYearAlone;
    private String placeOfBirth;
    private Integer uid;
    private Integer euid;
}
