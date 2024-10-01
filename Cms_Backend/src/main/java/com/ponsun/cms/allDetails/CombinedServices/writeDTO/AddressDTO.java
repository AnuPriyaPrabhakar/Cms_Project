package com.ponsun.cms.allDetails.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class AddressDTO {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String address;
    private Integer uid;
    private Integer euid;

    public AddressDTO(final Integer id,final Integer recordTypeId,final Integer cmsId,final String address , final Integer uid, final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.address = address;
        this.uid = uid;
        this.euid = euid;
    }
    public static AddressDTO newInstance (final Integer id, final Integer recordTypeId, final Integer cmsId, final String address , final Integer uid, final Integer euid){
        return new AddressDTO(id, recordTypeId,cmsId,address,uid,euid);
    }
}

