package com.ponsun.cms.allDetails.dateOfBirth.data;

import lombok.Data;

@Data
public class DateOfBirthData {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String dob;
    private String birthYearAlone;
    private String placeOfBirth;
    private Integer uid;
    private Integer euid;

    public DateOfBirthData(final Integer id,final Integer recordTypeId,final Integer cmsId,final String dob,final String birthYearAlone, final String placeOfBirth,final Integer uid, final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.dob = dob;
        this.birthYearAlone = birthYearAlone;
        this.placeOfBirth = placeOfBirth;
        this.uid = uid;
        this.euid = euid;
    }
    public static DateOfBirthData newInstance (final Integer id,final Integer recordTypeId,final Integer cmsId,final String dob,final String birthYearAlone, final String placeOfBirth,final Integer uid, final Integer euid){
        return new DateOfBirthData( id,recordTypeId,cmsId,dob,birthYearAlone,  placeOfBirth,uid,euid);
    }
}
