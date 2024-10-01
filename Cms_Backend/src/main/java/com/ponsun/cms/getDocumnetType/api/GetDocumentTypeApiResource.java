package com.ponsun.cms.getDocumnetType.api;

import com.ponsun.cms.getDocumnetType.services.GetDocumentTypeReadPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/GetDocumentType")
public class GetDocumentTypeApiResource {

    private  final GetDocumentTypeReadPlatformService getDocumentTypeReadPlatformService;
    @GetMapping
    public ResponseEntity<List<Integer>> fetchAll(@RequestParam Integer cmsId, @RequestParam Integer pathId) {
        List<Integer> documentTypes = this.getDocumentTypeReadPlatformService.getDocumentType(cmsId, pathId);
        return ResponseEntity.ok().body(documentTypes);
    }
}
