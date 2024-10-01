package com.ponsun.cms.FilesStorage.service;


import com.ponsun.cms.FilesStorage.domain.FileStorage;
import com.ponsun.cms.FilesStorage.domain.FileStorageRepository;
import com.ponsun.cms.FilesStorage.request.CreateFileStorageRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileStorageWritePlatformServiceImpl implements FileStorageWritePlatformService {
    private final JdbcTemplate jdbcTemplate;
    private final FileStorageRepository fileStorageRepository;

    private final String baseRoot = "D:\\uploadImages";

    @Override
    @Transactional
    public Response createFileStorage(CreateFileStorageRequest createFileStorageRequest) {
        try{
            final FileStorage fileStorage = FileStorage.create(createFileStorageRequest);
            this.fileStorageRepository.saveAndFlush(fileStorage);
            return Response.of(fileStorage.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void documentsave(MultipartFile documentfiles,Integer cmsId, Integer PathId,  Integer imgName) {
        String resolvedRootDirectory = "";

        Integer pathId = PathId;
        if (pathId == 1) {
            resolvedRootDirectory = "document\\Entity";
        } else if (pathId == 2) {
            resolvedRootDirectory = "document\\Individual";
        } else if (pathId == 3) {
            resolvedRootDirectory = "document\\Ship";
        } else if (pathId == 4) {
            resolvedRootDirectory = "document\\Aircraft";
        }

        Path root = Paths.get(baseRoot, resolvedRootDirectory);
        updatecompanyDocument(imgName);
        try {

            String fileExtensions = "";
            fileExtensions = documentfiles.getOriginalFilename().substring(documentfiles.getOriginalFilename().lastIndexOf(".") + 1);
            System.out.println("fileExtensions :" + fileExtensions);

            String folderName = cmsId.toString();
            Path folderPath = root.resolve(folderName);
            Files.createDirectories(folderPath);
            System.out.println("File saved: " + folderPath);

            CreateFileStorageRequest createFileStorageRequest = new CreateFileStorageRequest();
            createFileStorageRequest.setDocumentId(cmsId);
            createFileStorageRequest.setPathId(PathId);
            createFileStorageRequest.setDocumentType(fileExtensions);
            createFileStorageRequest.setUid(1);
            createFileStorageRequest.setUrl(folderPath.toString());

            Response response = createFileStorage(createFileStorageRequest);
            Integer imageId = (Integer) response.getId();

            String filename = imageId + "." + fileExtensions;
            Files.copy(documentfiles.getInputStream(), folderPath.resolve(filename));

        } catch (NullPointerException e) {
            throw new RuntimeException("File storage service is currently unavailable. Please try again later.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatecompanyDocument(Integer id) {
        try {
            String sql = "UPDATE `cms_document` SET STATUS = 'D', updated_at = NOW() WHERE id = ? and status ='A' ";
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException e) {
            System.err.println("Error updating the document: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

