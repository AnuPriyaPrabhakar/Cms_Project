package com.ponsun.cms.master.configDead.data;

import lombok.Data;

@Data
public class ConfigDeadData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public ConfigDeadData(final Integer id, final String name , final Integer uid, final Integer euid){
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.euid = euid;
    }
    public static ConfigDeadData newInstance (final Integer id, final String name , final Integer uid, final Integer euid){
        return new ConfigDeadData(id, name,uid,euid);
    }
}
