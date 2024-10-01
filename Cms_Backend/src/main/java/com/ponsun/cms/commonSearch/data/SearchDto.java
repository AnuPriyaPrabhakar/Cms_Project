package com.ponsun.cms.commonSearch.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class SearchDto {
    private String name;
    private double matching_score;
    private Integer recordTypeId;

    public SearchDto(String name, double matching_score, Integer recordTypeId) {
        this.name = name;
        this.matching_score = matching_score;
        this.recordTypeId = recordTypeId;
    }

    public static SearchDto newInstance(String name, double matching_score, Integer recordTypeId) {
        return new SearchDto(name, matching_score, recordTypeId);
    }
}
