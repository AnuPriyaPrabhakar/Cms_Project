package com.ponsun.cms.master.gender.data;

import lombok.Data;

@Data
public class GenderData {
    private Integer id;
    private String gender;


    public GenderData(final Integer id, final String gender) {

        this.id = id;
        this.gender = gender;
    }

    public static GenderData newInstance(final Integer id, final String gender) {
        return new GenderData(id, gender);
    }
}
