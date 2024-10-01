package com.ponsun.cms.countryHq.data;

import lombok.Data;

@Data
public class CountryHqData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public CountryHqData(final Integer id, final String name , final Integer uid, final Integer euid){
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static CountryHqData newInstance (final Integer id, final String name , final Integer uid, final Integer euid){
        return new CountryHqData(id, name,uid,euid);
    }
}
