package com.ponsun.cms.company.companyDetails.data;

import lombok.Data;

@Data
public class CompanyDetailsData {
    private Integer recordTypeId;
    private Integer cmsId;
    private Integer identificationNumberId;
    private Integer stateId;
    private String role;
    private String companyName;
    private String address;
    private String idDetails;
    private Integer uid;
    private Integer euid;

    public CompanyDetailsData(final Integer recordTypeId, final Integer cmsId, final Integer identificationNumberId,final Integer stateId , final String role , final String companyName , final String address ,final String idDetails ,final Integer uid, final Integer euid){
        this.recordTypeId = recordTypeId;
        this.cmsId=cmsId;
        this.identificationNumberId = identificationNumberId;
        this.stateId = stateId;
        this.role = role;
        this.companyName = companyName;
        this.address = address;
        this.idDetails = idDetails;
        this.uid = uid;
        this.euid = euid;
    }
    public static CompanyDetailsData newInstance (final Integer recordTypeId, final Integer cmsId, final Integer identificationNumberId,final Integer stateId , final String role , final String companyName , final String address ,final String idDetails ,final Integer uid, final Integer euid){
        return new CompanyDetailsData(recordTypeId, cmsId, identificationNumberId,stateId, role, companyName, address, idDetails, uid, euid);
    }
}
