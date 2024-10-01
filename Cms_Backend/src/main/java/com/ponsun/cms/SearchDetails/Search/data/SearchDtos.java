package com.ponsun.cms.SearchDetails.Search.data;

import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsData;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class SearchDtos {
    private Integer id;
    private Integer searchId;
    private String name;
    private double matchingScore;
    private String fromDate;
    private String toDate;
    private List<SearchDetailsData> searchDetailsDataList;

    public SearchDtos(final Integer id, final Integer searchId, final String name, final double matchingScore, final String fromDate, final String toDate , final List<SearchDetailsData> searchDetailsDataList) {
        this.id = id;
        this.searchId = searchId;
        this.name = name;
        this.matchingScore = matchingScore;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.searchDetailsDataList = searchDetailsDataList;
    }

    public static SearchDtos newInstance(final Integer id, final Integer searchId, final String name, final double matchingScore, final String fromDate, final String toDate, final List<SearchDetailsData> searchDetailsDataList) {
        return new SearchDtos(id, searchId, name, matchingScore, fromDate, toDate, searchDetailsDataList);
    }
}
