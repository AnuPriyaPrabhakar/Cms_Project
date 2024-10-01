package com.ponsun.cms.allDetails.aliases.data;

import lombok.Data;

@Data
public class AliasesData {
    private Integer id;
    private Integer recordTypeId;
    private Integer cmsId;
    private String aliasesName;
    private Integer uid;
    private Integer euid;

    public AliasesData (final Integer id,final Integer recordTypeId,final Integer cmsId,final String aliasesName , final Integer uid , final Integer euid){
        this.id = id;
        this.recordTypeId = recordTypeId;
        this.cmsId = cmsId;
        this.aliasesName = aliasesName;
        this.uid = uid;
        this.euid = euid;
    }
    public static AliasesData newInstance (final Integer id,final Integer recordTypeId,final Integer cmsId,final String aliasesName , final Integer uid , final Integer euid){
        return new AliasesData(id,recordTypeId,cmsId,aliasesName,uid,euid);
    }
}
