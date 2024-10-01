package com.ponsun.cms.cutomerEdit.data;

import lombok.Data;

@Data
public class CustomerEditData {
    private Integer cmsId;
    private Integer recordTypeId;
    private String name;
    private String sourceLink;
    private Integer genderId;
    private String frmDate;
    private String toDate;
    private Integer uid;
    private String created_at;
    private String userName;

    public  CustomerEditData (final Integer cmsId , final Integer recordTypeId , final String name,final String sourceLink ,  final String frmDate , final String toDate , final Integer genderId, final Integer uid , final String created_at , final String userName){
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.sourceLink = sourceLink;
        this.frmDate = frmDate;
        this.toDate = toDate;
        this.genderId = genderId;
        this.uid = uid;
        this.created_at = created_at;
        this.userName = userName;

    }

    public static  CustomerEditData newInstance (final Integer cmsId , final Integer recordTypeId , final String name,final String sourceLink ,  final String frmDate , final String toDate , final Integer genderId, final Integer uid , final String created_at , final String userName){

        return new CustomerEditData(cmsId , recordTypeId ,name , sourceLink , frmDate , toDate, genderId ,uid , created_at , userName);

    }

}
