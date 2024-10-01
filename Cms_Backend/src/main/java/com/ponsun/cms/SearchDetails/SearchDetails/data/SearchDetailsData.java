package com.ponsun.cms.SearchDetails.SearchDetails.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchDetailsData {
    private Integer id;
    private Integer searchId;
    private Integer cmsId;
    private String name;
    private double searchingScore;
    private Integer typeId;
    private Integer uid;
    private String fromDate;
    private String toDate;

    public SearchDetailsData(final Integer id,Integer searchId,Integer cmsId, final String name, final double searchingScore, final Integer typeId, final Integer uid, final String fromDate, final String toDate) {
        this.id = id;
        this.searchId = searchId;
        this.cmsId= cmsId;
        this.name = name;
        this.searchingScore = searchingScore;
        this.typeId = typeId;
        this.uid = uid;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static SearchDetailsData newInstance(final Integer id,Integer searchId,Integer cmsId, final String name, final double searchingScore, final Integer typeId, final Integer uid, final String fromDate, final String toDate) {
        return new SearchDetailsData(id,searchId,cmsId, name, searchingScore, typeId, uid,fromDate,toDate);
    }
}
