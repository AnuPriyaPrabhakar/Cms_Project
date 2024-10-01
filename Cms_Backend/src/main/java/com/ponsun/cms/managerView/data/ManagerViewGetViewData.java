package com.ponsun.cms.managerView.data;

import lombok.Data;

@Data
public class ManagerViewGetViewData {
    private Integer cmsId;
    private String userName;
    private String cmsName;
    private String sourceLink;
    private Integer genderId;
    private Integer uid;
    private Integer recordTypeId;

    public ManagerViewGetViewData(final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId , final Integer uid , final  Integer recordTypeId) {
        this.cmsId = cmsId;
        this.userName = userName;
        this.cmsName = cmsName;
        this.sourceLink = sourceLink;
        this.genderId = genderId;
        this.uid = uid;
        this.recordTypeId = recordTypeId;
    }

    public static ManagerViewGetViewData newInstance (final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId, final Integer uid , final  Integer recordTypeId) {
        return new ManagerViewGetViewData(cmsId,userName, cmsName, sourceLink, genderId,uid,recordTypeId);
    }
}
