package com.ponsun.cms.getDocumnetType.data;

import lombok.Data;

@Data
public class GetDocumentTypeData {

    private Integer id;
    private Integer documentId;
    private Integer pathId;
    private String documentType;

    public  GetDocumentTypeData (final Integer id,final Integer documentId , final Integer pathId , final String documentType){
        this.id= id;
        this.documentId = documentId;
        this.pathId = pathId;
        this.documentType = documentType;
    }
    public static GetDocumentTypeData newInstance (final Integer id, final Integer documentId , final Integer pathId , final String documentType){
        return new GetDocumentTypeData(id,documentId ,pathId , documentType);
    }
}
