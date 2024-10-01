package com.ponsun.cms.master.RecordType.data;

import lombok.Data;

@Data
public class RecordTypeData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public RecordTypeData(final Integer id, final String name , final Integer uid, final Integer euid){
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static RecordTypeData newInstance (final Integer id, final String name , final Integer uid, final Integer euid){
        return new RecordTypeData(id, name,uid,euid);
    }
}
