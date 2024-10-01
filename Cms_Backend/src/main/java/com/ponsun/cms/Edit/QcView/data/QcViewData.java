package com.ponsun.cms.Edit.QcView.data;

import lombok.Data;

@Data
public class QcViewData {
    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;
    private String fromDate;
    private String toDate;



    public  QcViewData (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate){
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.genderId = genderId;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static QcViewData newInstance (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate) {
        return new QcViewData(recordTypeId , name ,genderId ,  sourceLink ,fromDate,toDate);
    }
}

