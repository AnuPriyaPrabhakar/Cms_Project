package com.ponsun.cms.master.contactDetails.data;

import lombok.Data;

@Data
public class ContactDetailsData {
    private Integer id;
    private String name;


    public ContactDetailsData(final Integer id, final String name) {

        this.id = id;
        this.name = name;
    }

    public static ContactDetailsData newInstance(final Integer id, final String name) {
        return new ContactDetailsData(id, name);
    }
}
