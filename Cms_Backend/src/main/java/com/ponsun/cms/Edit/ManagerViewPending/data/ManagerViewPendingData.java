package com.ponsun.cms.Edit.ManagerViewPending.data;

import lombok.Data;

@Data
public class ManagerViewPendingData {
    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;
    private String fromDate;
    private String toDate;



    public ManagerViewPendingData(final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate){
        this.recordTypeId = recordTypeId;
        this.name = name;
        this.genderId = genderId;
        this.sourceLink = sourceLink;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    public static ManagerViewPendingData newInstance (final Integer recordTypeId , final String name , final Integer genderId , final String sourceLink , final String fromDate , final String toDate) {
        return new ManagerViewPendingData(recordTypeId , name ,genderId ,  sourceLink ,fromDate,toDate);
    }
}
