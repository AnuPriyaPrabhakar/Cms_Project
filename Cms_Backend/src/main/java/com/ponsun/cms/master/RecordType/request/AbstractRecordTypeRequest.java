package com.ponsun.cms.master.RecordType.request;

import lombok.Data;

@Data
public class AbstractRecordTypeRequest {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;
}
