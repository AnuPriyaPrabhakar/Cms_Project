package com.ponsun.cms.regulatorList.data;

import lombok.Data;

@Data
public class RegulatorListData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public RegulatorListData(final Integer id, final String name , final Integer uid, final Integer euid){
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static RegulatorListData newInstance (final Integer id, final String name , final Integer uid, final Integer euid){
        return new RegulatorListData(id, name,uid,euid);
    }
}
