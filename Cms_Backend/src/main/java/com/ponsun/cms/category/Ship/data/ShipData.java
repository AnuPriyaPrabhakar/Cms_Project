package com.ponsun.cms.category.Ship.data;

import lombok.Data;

@Data
public class ShipData {
    private Integer cmsId;
    private String userName;
    private String cmsName;
    private String sourceLink;
    private Integer genderId;

    public ShipData(final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        this.cmsId = cmsId;
        this.userName = userName;
        this.cmsName = cmsName;
        this.sourceLink = sourceLink;
        this.genderId = genderId;
    }

    public static ShipData newInstance (final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        return new ShipData(cmsId,userName, cmsName, sourceLink, genderId);
    }
}
