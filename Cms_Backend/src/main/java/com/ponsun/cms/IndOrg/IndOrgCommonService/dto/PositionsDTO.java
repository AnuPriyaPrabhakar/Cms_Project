package com.ponsun.cms.IndOrg.IndOrgCommonService.dto;

import com.ponsun.cms.IndOrg.positions.data.PositionsData;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PositionsDTO {

    private Integer id;
    private Integer cmsId;
    private Integer recordTypeId;
    private String position;
    private String linIndName;
    private Integer uid;
    private Integer euid;

    public PositionsDTO (final Integer id , final Integer cmsId , final Integer recordTypeId , final String position , final String linIndName,final Integer uid , final Integer euid) {
        this.id = id;
        this.cmsId = cmsId;
        this.recordTypeId = recordTypeId;
        this.position = position;
        this.linIndName = linIndName;
        this.uid = uid;
        this.euid = euid;
    }

    public static PositionsDTO newInstance(final Integer id , final Integer cmsId , final Integer recordTypeId , final String position , final String linIndName, final Integer uid , final Integer euid) {
        return new PositionsDTO (id, cmsId, recordTypeId, position, linIndName,uid,euid);
    }
}
