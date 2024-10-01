package com.ponsun.cms.commonSearch.api;

import com.ponsun.cms.commonSearch.data.RecordsDto;
import com.ponsun.cms.commonSearch.data.SearchDto;
import com.ponsun.cms.commonSearch.services.CommonSearchReadService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/Search")
@Tag(name = "SearchRecordsApiResources")

public class CommonSearchApiResources {

    private final CommonSearchReadService commonSearchReadService;
    @GetMapping("/RecordsCount")
    public List<RecordsDto> getRecords(@RequestBody SearchDto searchDto){
        return this.commonSearchReadService.getRecords(searchDto);
    }
}
