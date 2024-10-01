package com.ponsun.cms.reports.CreatedAt.data;

import lombok.Data;

@Data
public class CreatedAtData {

    private String name;
    private Integer count;
    private String frmDate;
    private String toDate;

    public  CreatedAtData (final String name , final Integer count , final String frmDate , final String toDate){
        this.name = name;
        this.count = count;
        this.frmDate = frmDate;
        this.toDate = toDate;
    }
    public static CreatedAtData newInstance (final String name , final Integer count ,final String frmDate , final String toDate){
        return new CreatedAtData(name , count ,frmDate ,  toDate);
    }
}
