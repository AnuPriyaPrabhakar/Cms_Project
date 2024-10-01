package com.ponsun.cms.allDetails.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class DateOfBirthDTO {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String dob;
    private String birthYearAlone;
    private String placeOfBirth;
    private Integer uid;
    private Integer euid;

    public DateOfBirthDTO(final Integer id, final Integer recordTypeId, final Integer cmsId, final String dob, final String birthYearAlone, final String placeOfBirth, final Integer uid, final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.dob = dob;
        this.birthYearAlone = birthYearAlone;
        this.placeOfBirth = placeOfBirth;
        this.uid = uid;
        this.euid = euid;
    }
    public static DateOfBirthDTO newInstance (final Integer id, final Integer recordTypeId, final Integer cmsId, final String dob, final String birthYearAlone, final String placeOfBirth, final Integer uid, final Integer euid){
        return new DateOfBirthDTO( id,recordTypeId,cmsId,dob,birthYearAlone,  placeOfBirth,uid,euid);
    }
}
