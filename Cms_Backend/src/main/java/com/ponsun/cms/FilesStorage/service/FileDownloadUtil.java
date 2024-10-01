package com.ponsun.cms.FilesStorage.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.apache.commons.io.FilenameUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication

public class FileDownloadUtil {

    private Path foundFile;
    private final String baseRoot = "D:\\uploadImages";
    public List<String> getDocument(Integer cmsId, Integer pathId) throws IOException {
        String resolvedRootDirectory = "";

        if (pathId == 1) {
            resolvedRootDirectory = "document\\Entity";
        } else if (pathId == 2) {
            resolvedRootDirectory = "document\\Individual";
        } else if (pathId == 3) {
            resolvedRootDirectory = "document\\Ship";
        } else if (pathId == 4) {
            resolvedRootDirectory = "document\\Aircraft";
        }

        Path root = Paths.get(baseRoot, resolvedRootDirectory, String.valueOf(cmsId));

        if (Files.exists(root) && Files.isDirectory(root)) {
            try (Stream<Path> files = Files.list(root)) {
                List<String> documentList = files
                        .filter(Files::isRegularFile)
                        .map(Path::getFileName)
                        .map(Path::toString)
                        .collect(Collectors.toList());
                System.out.println("documentList: " + documentList);
                return documentList;
            }
        }
        return Collections.emptyList();
    }



// ...

//    public Resource documentList(Integer cmsId, Integer pathId, String fileName) throws IOException {
//        String resolvedRootDirectory = "";
//
//        if (pathId == 1) {
//            resolvedRootDirectory = "document\\Entity";
//        } else if (pathId == 2) {
//            resolvedRootDirectory = "document\\Individual";
//        } else if (pathId == 3) {
//            resolvedRootDirectory = "document\\Ship";
//        } else if (pathId == 4) {
//            resolvedRootDirectory = "document\\Aircraft";
//        }
//
//        Path root = Paths.get(baseRoot, resolvedRootDirectory, String.valueOf(cmsId));
//        Path filePath = root.resolve(FilenameUtils.removeExtension(fileName));
//
//        System.out.println("File Path: " + filePath);
//
//        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
//            return new UrlResource(filePath.toUri());
//        }
//
//        return null;
//    }

    public Resource documentList(Integer cmsId,Integer pathId, String fileName) throws IOException {
        String resolvedRootDirectory = "";

        if (pathId == 1) {
            resolvedRootDirectory = "document\\Entity";
        } else if (pathId == 2) {
            resolvedRootDirectory = "document\\Individual";
        } else if (pathId == 3) {
            resolvedRootDirectory = "document\\Ship";
        } else if (pathId == 4) {
            resolvedRootDirectory = "document\\Aircraft";
        }

        Path root = Paths.get(baseRoot, resolvedRootDirectory, String.valueOf(cmsId));
        Path filePath = root.resolve(fileName);

        System.out.println("File Path: " + filePath);

        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            return new UrlResource(filePath.toUri());
        }

        return null;
    }

}
