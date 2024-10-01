package com.ponsun.cms.FilesStorage.service;


import com.ponsun.cms.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.cms.infrastructure.utils.Response;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageWritePlatformService {
    Response createFileStorage(CreateFileStorageRequest createFileStorageRequest);

    void documentsave(MultipartFile documentfiles, Integer cmsId,Integer PathId, Integer imgName);

    void updatecompanyDocument(Integer id);
}
