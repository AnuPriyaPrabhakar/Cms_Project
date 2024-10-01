package com.ponsun.cms.bankDetails.data;

import lombok.Data;

@Data
public class BankDetailsData {
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer bankId;
    private String acc_no;
    private String name;
    private Integer uid;
    private Integer euid;

    public BankDetailsData(final Integer recordTypeId, final Integer cmsId, final Integer bankId,final String acc_no , final String name , final Integer uid, final Integer euid){
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.bankId = bankId;
        this.acc_no = acc_no;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static BankDetailsData newInstance (final Integer recordTypeId, final Integer cmsId, final Integer bankId,final String acc_no , final String name , final Integer uid, final Integer euid){
        return new BankDetailsData(recordTypeId,cmsId,bankId,acc_no,name,uid,euid);
    }
}
