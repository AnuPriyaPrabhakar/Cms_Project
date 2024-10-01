package com.ponsun.cms.master.RecordType.api;

import com.ponsun.cms.master.RecordType.domain.RecordType;
import com.ponsun.cms.master.RecordType.request.CreateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.request.UpdateRecordTypeRequest;
import com.ponsun.cms.master.RecordType.services.RecordTypeReadPlatformService;
import com.ponsun.cms.master.RecordType.services.RecordTypeWritePlatformService;
import com.ponsun.cms.infrastructure.utils.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/RecordType")
@Tag(name = "RecordTypeApiResource")
public class RecordTypeApiResource {
    private final RecordTypeWritePlatformService recordTypeWritePlatformService;
    private final RecordTypeReadPlatformService recordTypeReadPlatformService;
    @PostMapping("/CreateRecordTypeRequest")
    public Response saveAddress(@RequestBody CreateRecordTypeRequest createRecordTypeRequest){
        Response response = this.recordTypeWritePlatformService.createRecordType(createRecordTypeRequest);
        return response;
    }
    @GetMapping
    public List<RecordType> fetchAll(){ return this.recordTypeReadPlatformService.fetchAllRecordType();}

    @GetMapping("/{id}")
    public RecordType fetchRecordTypeById(@PathVariable(name = "id")Integer id){
        return this.recordTypeReadPlatformService.fetchRecordTypeById(id);
    }

    @PutMapping("/{id}")
    public Response updateRecordType(@PathVariable Integer id, @RequestBody UpdateRecordTypeRequest updateRecordTypeRequest){
        Response response = this.recordTypeWritePlatformService.updateRecordType(id,updateRecordTypeRequest);
        return  response;
    }

}
