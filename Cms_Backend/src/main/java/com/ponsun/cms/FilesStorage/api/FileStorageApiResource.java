package com.ponsun.cms.FilesStorage.api;


import com.ponsun.cms.FilesStorage.service.FileDownloadUtil;
import com.ponsun.cms.FilesStorage.service.FileStorageWritePlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/v1/Document")
@Tag(name = "DocumentApiResource")
public class FileStorageApiResource {

    private final FileStorageWritePlatformService fileStorageWritePlatformService;
    private final JdbcTemplate jdbcTemplate;

    @PostMapping("/company/upload")
    public ResponseEntity<String> imageFiles(@RequestParam("files") MultipartFile[] files, Integer[] pathId,
                                             Integer documentId, Integer imgName) {
        List<String> messages = new ArrayList<>();

        try {
            for (int j = 0; j < files.length; j++) {
                fileStorageWritePlatformService.documentsave(files[j], pathId[j], documentId, imgName);
                messages.add(files[j].getOriginalFilename() + " [Successful]");
            }
            return ResponseEntity.ok(messages.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred: " + e.getMessage());
        }
    }

    @GetMapping("/downloadDocument/{cmsId}/{pathId}")
    public ResponseEntity<?> downloadDocument(@PathVariable("cmsId") Integer cmsId, @PathVariable("pathId") Integer pathId) {
        FileDownloadUtil downloadUtil = new FileDownloadUtil();

        String sql = "SELECT id ,CONCAT(id, '.', documentType) AS concatenated_name FROM cms_document WHERE documentId = ? AND pathId = ? AND STATUS='A'";

        List<String> fileNames = jdbcTemplate.query(sql, new Object[]{cmsId, pathId}, (resultSet, rowNum) ->
                resultSet.getString("concatenated_name"));

        List<ResponseEntity<Resource>> responses = new ArrayList<>();

        System.out.println("fileNames:" + fileNames);
        for (String fileName : fileNames) {
            System.out.println("fileName:" + fileName);
            Resource resource = null;
            try {
                resource = downloadUtil.documentList(cmsId, pathId, fileName);
            } catch (IOException e) {
                System.err.println("Error loading file: " + fileName);
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }

            if (resource == null) {
                System.err.println("File not found: " + fileName);
                continue;
            }

            String contentType = "application/octet-stream";
            String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

            responses.add(ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                    .body(resource));
        }

        if (responses.isEmpty()) {
            return new ResponseEntity<>("No valid documents found", HttpStatus.NOT_FOUND);
        } else {

            return responses.get(0);
        }
    }
}
