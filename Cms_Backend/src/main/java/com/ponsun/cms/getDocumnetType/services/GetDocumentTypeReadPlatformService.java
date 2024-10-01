package com.ponsun.cms.getDocumnetType.services;


import java.util.List;

public interface GetDocumentTypeReadPlatformService {
    List<Integer> getDocumentType(Integer cmsId, Integer pathId);
}
