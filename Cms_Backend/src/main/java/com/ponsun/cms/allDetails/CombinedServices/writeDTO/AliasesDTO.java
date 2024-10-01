package com.ponsun.cms.allDetails.CombinedServices.writeDTO;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AliasesDTO {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;

    public AliasesDTO (final Integer id,final Integer recordTypeId,final Integer cmsId,final String aliasesName , final Integer uid , final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.aliasesName = aliasesName;
        this.uid = uid;
        this.euid = euid;
    }
    public static AliasesDTO newInstance (final Integer id,final Integer recordTypeId,final Integer cmsId,final String aliasesName , final Integer uid , final Integer euid){
        return new AliasesDTO(id,recordTypeId,cmsId,aliasesName,uid,euid);
    }
}
