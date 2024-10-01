package com.ponsun.cms.IndOrg.positions.data;

import lombok.Data;

@Data
public class    PositionsData {
    private Integer id;
    private Integer cmsId;
    private Integer recordTypeId;
    private String position;
    private String linIndName;
    private Integer uid;
    private Integer euid;

    public PositionsData (final Integer id , final Integer cmsId , final Integer recordTypeId , final String position , final String linIndName,final Integer uid , final Integer euid) {
        this.id = id;
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.position = position;
        this.linIndName = linIndName;
        this.uid = uid;
        this.euid = euid;
    }

    public static PositionsData newInstance(final Integer id , final Integer cmsId , final Integer recordTypeId , final String position , final String linIndName,final Integer uid , final Integer euid) {
        return new PositionsData(id, cmsId, recordTypeId, position, linIndName,uid,euid);
    }
}
