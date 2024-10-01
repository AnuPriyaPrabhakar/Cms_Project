package com.ponsun.cms.category.Individual.api;


import com.ponsun.cms.category.Individual.data.IndividualData;
import com.ponsun.cms.category.Individual.services.IndividualReaPlatformService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/Individual")
public class IndividualApiResource {
    private  final IndividualReaPlatformService individualReaPlatformService;
    @GetMapping
    public List<IndividualData> fetchAll(String cmsName ){
        return this.individualReaPlatformService.fetchAllIndividualData(cmsName);}
}
