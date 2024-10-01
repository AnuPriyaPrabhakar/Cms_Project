package com.ponsun.cms.category.Individual.data;

import lombok.Data;

@Data
public class IndividualData {
    private Integer cmsId;
    private String userName;
    private String cmsName;
    private String sourceLink;
    private Integer genderId;

    public IndividualData(final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        this.cmsId = cmsId;
        this.userName = userName;
        this.cmsName = cmsName;
        this.sourceLink = sourceLink;
        this.genderId = genderId;
    }

    public static IndividualData newInstance (final Integer cmsId , String userName, final String cmsName , final String sourceLink , final Integer genderId) {
        return new IndividualData(cmsId,userName, cmsName, sourceLink, genderId);
    }
}
