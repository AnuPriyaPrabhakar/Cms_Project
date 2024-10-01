package com.ponsun.cms.category.Aircraft.data;

import lombok.Data;

@Data
public class AircraftData {
    private Integer cmsId;
    private String userName;
    private String cmsName;
    private String sourceLink;
    private Integer genderId;

    public AircraftData(final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        this.cmsId = cmsId;
        this.userName = userName;
        this.cmsName = cmsName;
        this.sourceLink = sourceLink;
        this.genderId = genderId;
    }

    public static AircraftData newInstance (final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        return new AircraftData(cmsId,userName, cmsName, sourceLink, genderId);
    }
}
