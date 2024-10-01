package com.ponsun.cms.allDetails.address.data;

import lombok.Data;

@Data
public class AddressData {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String address;
    private Integer uid;
    private Integer euid;

    public AddressData(final Integer id,final Integer recordTypeId,final Integer cmsId,final String address , final Integer uid, final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.address = address;
        this.uid = uid;
        this.euid = euid;
    }
    public static AddressData newInstance (final Integer id,final Integer recordTypeId,final Integer cmsId, final String address , final Integer uid, final Integer euid){
        return new AddressData(id, recordTypeId,cmsId,address,uid,euid);
    }
}
