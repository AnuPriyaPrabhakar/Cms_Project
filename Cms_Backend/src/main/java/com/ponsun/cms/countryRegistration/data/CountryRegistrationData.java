package com.ponsun.cms.countryRegistration.data;

import lombok.Data;

@Data
public class CountryRegistrationData {
    private Integer id;
    private Integer countryId;
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer countryHqId;
    private Integer identificationNumberId;
    private String identificationNum;
    private String identificationDetails;
    private Integer contactId;
    private String contactName;
    private String status;
    private Integer uid;
    private Integer euid;

    public CountryRegistrationData(final Integer id,final Integer countryId, final Integer recordTypeId,final Integer cmsId, final Integer countryHqId, final Integer identificationNumberId, final String identificationNum, final String identificationDetails,final Integer contactId , final String contactName, final String status, final Integer uid, final Integer euid){
        this.id = id;
        this.countryId = countryId;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.countryHqId = countryHqId;
        this.identificationNumberId = identificationNumberId;
        this.identificationNum = identificationNum;
        this.identificationDetails = identificationDetails;
        this.contactId = contactId;
        this.contactName = contactName;
        this.status = status;
        this.uid = uid;
        this.euid = euid;
    }
    public static CountryRegistrationData newInstance (final Integer id,final Integer countryId, final Integer recordTypeId, final Integer cmsId, final Integer countryHqId, final Integer identificationNumberId, final String identificationNum, final String identificationDetails,final Integer contactId , final String contactName, final String status, final Integer uid, final Integer euid){
        return new CountryRegistrationData(id, countryId,recordTypeId,cmsId,countryHqId,identificationNumberId,identificationNum,identificationDetails,contactId,contactName,status,uid,euid);
    }
}
