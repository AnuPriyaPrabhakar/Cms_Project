package com.ponsun.cms.Edit.Manager.data;

import lombok.Data;

@Data
public class QcManagerPendingData {

    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;
    private String fromDate;
    private String toDate;
    private Integer cmsId;



    public  QcManagerPendingData (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate , final Integer cmsId){
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.genderId = genderId;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.cmsId = cmsId;
    }


    public static QcManagerPendingData newInstance (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate , final Integer cmsId) {
        return new QcManagerPendingData(recordTypeId , name ,genderId ,  sourceLink ,fromDate,toDate,cmsId);
    }
}

