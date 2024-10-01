package com.ponsun.cms.IndPositions.data;

import lombok.Data;

@Data
public class IndPositionsData {
    private Integer cmsId;
    private Integer recordTypeId;
    private String position;
    private Integer uid;
    private Integer euid;

    public IndPositionsData (final Integer cmsId ,final Integer recordTypeId , final String position , final Integer uid , final Integer euid) {
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.position = position;
        this.uid = uid;
        this.euid = euid;
    }

    public static IndPositionsData newInstance (final Integer cmsId , final Integer recordTypeId ,final String position , final Integer uid , final Integer euid) {
        return new IndPositionsData(cmsId, recordTypeId , position,uid,euid);
    }
}
