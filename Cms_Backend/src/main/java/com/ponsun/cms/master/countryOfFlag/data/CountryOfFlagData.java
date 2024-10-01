package com.ponsun.cms.master.countryOfFlag.data;

import lombok.Data;

@Data
public class CountryOfFlagData {
    private Integer id;
    private String name;


    public CountryOfFlagData(final Integer id, final String name) {

        this.id = id;
        this.name = name;
    }

    public static CountryOfFlagData newInstance(final Integer id, final String name) {
        return new CountryOfFlagData(id, name);
    }
}
