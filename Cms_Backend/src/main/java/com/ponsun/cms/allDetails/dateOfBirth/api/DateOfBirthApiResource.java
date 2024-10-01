package com.ponsun.cms.allDetails.dateOfBirth.api;

import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirth;
import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.request.UpdateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.services.DateOfBirthReadPlatformService;
import com.ponsun.cms.allDetails.dateOfBirth.services.DateOfBirthWritePlatformService;
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
@RequestMapping("/api/v1/DateOfBirth")
@Tag(name = "DateOfBirthApiResource")
public class DateOfBirthApiResource {
    private final DateOfBirthWritePlatformService dateOfBirthWritePlatformService;
    private final DateOfBirthReadPlatformService dateOfBirthReadPlatformService;
    @PostMapping("/CreateDateOfBirthRequest")
    public Response saveDateOfBirth(@RequestBody CreateDateOfBirthRequest createDateOfBirthRequest){
        Response response = this.dateOfBirthWritePlatformService.createDateOfBirth(createDateOfBirthRequest);
        return response;
    }
    @GetMapping
    public List<DateOfBirth> fetchAll(){ return this.dateOfBirthReadPlatformService.fetchAllDateOfBirth();}

    @GetMapping("/{id}")
    public DateOfBirth fetchDateOfBirthById(@PathVariable(name = "id")Integer id){
        return this.dateOfBirthReadPlatformService.fetchDateOfBirthById(id);
    }


    @PutMapping("/{id}")
    public Response updateDateOfBirth(@PathVariable Integer id, @RequestBody UpdateDateOfBirthRequest updateAliasesNameRequest){
        Response response = this.dateOfBirthWritePlatformService.updateDateOfBirth(id,updateAliasesNameRequest);
        return  response;
    }
}
