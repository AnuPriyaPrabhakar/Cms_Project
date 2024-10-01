package com.ponsun.cms.IndCaseDetails.data;

import lombok.Data;

@Data
public class IndCaseDetailsData {
    private Integer recordTypeId;
    private Integer cmsId;
    private String caseDetails;
    private Integer uid;
    private Integer euid;

    public IndCaseDetailsData(final Integer recordTypeId, final Integer cmsId, final String caseDetails, final Integer uid, final Integer euid){
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.caseDetails = caseDetails;
        this.uid = uid;
        this.euid = euid;
    }
    public static IndCaseDetailsData newInstance (final Integer recordTypeId, final Integer cmsId, final String caseDetails, final Integer uid, final Integer euid){
        return new IndCaseDetailsData(recordTypeId,cmsId,caseDetails,uid,euid);
    }
}
