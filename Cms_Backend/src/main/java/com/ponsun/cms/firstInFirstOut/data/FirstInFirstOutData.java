package com.ponsun.cms.firstInFirstOut.data;

import lombok.Data;

@Data
public class FirstInFirstOutData {
    private Integer id;
    private Integer recordTypeId;
    private String name;
    private Integer genderId;
    private String sourceLink;



        public FirstInFirstOutData (final Integer id, final Integer recordTypeId,final String name,final Integer genderId,final String sourceLink) {
        this.id=id;
        this.recordTypeId=recordTypeId;
        this.name=name;
        this.genderId=genderId;
        this.sourceLink=sourceLink;
    }
    public static FirstInFirstOutData newInstance (final Integer id, final Integer recordTypeId,final String name,final Integer genderId,final String sourceLink) {
        return new FirstInFirstOutData(id, recordTypeId, name, genderId, sourceLink);
    }

}
