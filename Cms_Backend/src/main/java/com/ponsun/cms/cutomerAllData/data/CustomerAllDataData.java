package com.ponsun.cms.cutomerAllData.data;

import lombok.Data;

@Data
public class CustomerAllDataData {
    private Integer genderId;
    private Integer recordTypeId;
    private Integer cmsId;
    private String userName;
    private String name;
    private String sourceLink;
    private String frmDate;
    private String toDate;
    private String uid;
    private String created_at;

    public CustomerAllDataData (final Integer genderId, final Integer recordTypeId , final Integer cmsId , final String userName , final String  name , final String sourceLink , final String frmDate , final String toDate, final  String uid , final String created_at){
        this.genderId = genderId;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.userName = userName;
        this.name = name;
        this.sourceLink = sourceLink;
        this.frmDate = frmDate;
        this.toDate = toDate;
        this.uid = uid;
        this.created_at = created_at;

    }

    public static CustomerAllDataData newInstance (final Integer genderId, final Integer recordTypeId , final Integer cmsId , final String userName , final String  name , final String sourceLink , final String frmDate , final String toDate, final  String uid , final String created_at) {
        return new CustomerAllDataData(genderId , recordTypeId, cmsId , userName ,name  , sourceLink , frmDate , toDate ,uid , created_at);
    }

}
