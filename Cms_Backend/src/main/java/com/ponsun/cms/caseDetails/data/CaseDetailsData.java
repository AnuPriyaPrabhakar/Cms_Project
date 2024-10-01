package com.ponsun.cms.caseDetails.data;

import lombok.Data;

@Data
public class CaseDetailsData {
    private Integer recordTypeId;
    private Integer cmsId;
    private String caseDetails;
    private Integer uid;
    private Integer euid;

    public CaseDetailsData (final Integer recordTypeId, final Integer cmsId,final String caseDetails, final Integer uid, final Integer euid){
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.caseDetails = caseDetails;
        this.uid = uid;
        this.euid = euid;
    }
    public static CaseDetailsData newInstance (final Integer recordTypeId,final Integer cmsId,final String caseDetails, final Integer uid, final Integer euid){
        return new CaseDetailsData(recordTypeId,cmsId,caseDetails,uid,euid);
    }
}
