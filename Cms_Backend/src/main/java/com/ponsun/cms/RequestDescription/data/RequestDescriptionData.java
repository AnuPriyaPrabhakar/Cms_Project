package com.ponsun.cms.RequestDescription.data;

import lombok.Data;

@Data
public class RequestDescriptionData {
    private Integer id;
    private Integer cmsId;
    private String description;
    private Integer uid;
    public RequestDescriptionData(final Integer id,final Integer cmsId,final String description,final Integer uid ){
        this.id= id;
        this.cmsId = cmsId;
        this.description = description;
        this.uid = uid;
    }
    public static  RequestDescriptionData newInstance(final Integer id,final  Integer cmsId,final String description,final Integer uid){
        return new RequestDescriptionData(id,cmsId,description,uid);
    }
}

