package com.ponsun.cms.Edit.ViewApprove.data;

import lombok.Data;

@Data
public class ViewApproveData {
    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;
    private String fromDate;
    private String toDate;



    public  ViewApproveData (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate){
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.genderId = genderId;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static ViewApproveData newInstance (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate) {
        return new ViewApproveData(recordTypeId , name ,genderId ,  sourceLink ,fromDate,toDate);
    }
}
