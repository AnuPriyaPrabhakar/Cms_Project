package com.ponsun.cms.Edit.Manager.data;

import lombok.Data;

@Data
public class QcManagerData {

    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;
    private String fromDate;
    private String toDate;



    public  QcManagerData (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate){
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.genderId = genderId;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static QcManagerData newInstance (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate) {
        return new QcManagerData(recordTypeId , name ,genderId ,  sourceLink ,fromDate,toDate);
    }
}

