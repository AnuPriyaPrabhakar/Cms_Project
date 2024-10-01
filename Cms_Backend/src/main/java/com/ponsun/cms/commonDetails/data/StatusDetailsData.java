package com.ponsun.cms.commonDetails.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StatusDetailsData {

    private Integer cmsId;
    private String cmsName;
    private String cmsRecordType;
    private Integer recordTypeId;
    private String registrationNum;

    public StatusDetailsData(Integer cmsId , String cmsName, String cmsRecordType, Integer recordTypeId, String registrationNum  ){
        this.cmsId=cmsId;
        this.cmsName = cmsName;
        this.cmsRecordType = cmsRecordType;
        this.recordTypeId = recordTypeId;
        this.registrationNum = registrationNum;
    }
    public static StatusDetailsData newInstance (Integer cmsId , String cmsName, String cmsRecordType, Integer recordTypeId, String registrationNum  ){
        return new StatusDetailsData(cmsId, cmsName, cmsRecordType,recordTypeId, registrationNum);
    }
}
