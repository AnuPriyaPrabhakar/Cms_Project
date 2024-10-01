package com.ponsun.cms.master.countryOfBirth.data;

import lombok.Data;

@Data
public class CountryOfBirthData {
    private Integer id;
    private String name;


    public CountryOfBirthData(final Integer id, final String name) {

        this.id = id;
        this.name = name;
    }

    public static CountryOfBirthData newInstance(final Integer id, final String name) {
        return new CountryOfBirthData(id, name);
    }
}
