package com.ponsun.cms.bankDetails.request;

import lombok.Data;

@Data
public class AbstractBankDetailsRequest {
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer bankId;
    private String acc_no;
    private String name;
    private Integer uid;
    private Integer euid;
}
