package com.ponsun.cms.commonSearch.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RecordsDto {
    private Integer cmsId;
    private String cmsName;
    private String cmsRecordType;
    private Double score;
    private Integer recordTypeId;
    public RecordsDto(Integer cmsId, String cmsName, String cmsRecordType, Double score ,Integer recordTypeId ) {
        this.cmsId = cmsId;
        this.cmsName = cmsName;
        this.cmsRecordType = cmsRecordType;
        this.score = score;
    }

    public static RecordsDto newInstance(Integer cmsId, String cmsName, String cmsRecordType, Double score,Integer recordTypeId ) {
        return new RecordsDto(cmsId, cmsName, cmsRecordType, score,recordTypeId);
    }
}
