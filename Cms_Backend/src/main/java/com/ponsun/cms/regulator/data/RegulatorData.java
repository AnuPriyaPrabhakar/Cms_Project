package com.ponsun.cms.regulator.data;

import lombok.Data;

@Data
public class RegulatorData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public RegulatorData(final Integer id, final String name , final Integer uid, final Integer euid){
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static RegulatorData newInstance (final Integer id, final String name , final Integer uid, final Integer euid){
        return new RegulatorData(id, name,uid,euid);
    }
}
