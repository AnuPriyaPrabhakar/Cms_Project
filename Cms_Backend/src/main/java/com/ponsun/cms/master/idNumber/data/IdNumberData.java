package com.ponsun.cms.master.idNumber.data;

import lombok.Data;

@Data
public class IdNumberData {
    private Integer id;
    private String name;


    public IdNumberData(final Integer id, final String name) {

        this.id = id;
        this.name = name;
    }

    public static IdNumberData newInstance(final Integer id, final String name) {
        return new IdNumberData(id, name);
    }
}
