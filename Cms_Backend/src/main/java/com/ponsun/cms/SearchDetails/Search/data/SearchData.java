package com.ponsun.cms.SearchDetails.Search.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SearchData {
    private Integer id;
    private String name;
    private double matchingScore;
    private String fromDate;
    private String toDate;

    public SearchData(final Integer id, final String name, final double matchingScore, final String fromDate, final String toDate) {
        this.id = id;
        this.name = name;
        this.matchingScore = matchingScore;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static SearchData newInstance(final Integer id, final String name, final double matchingScore, final String fromDate, final String toDate) {
        return new SearchData(id, name, matchingScore, fromDate, toDate);
    }
}
