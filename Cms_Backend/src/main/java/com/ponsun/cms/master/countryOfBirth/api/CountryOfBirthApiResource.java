package com.ponsun.cms.master.countryOfBirth.api;



import com.ponsun.cms.master.countryOfBirth.domain.CountryOfBirth;
import com.ponsun.cms.master.countryOfBirth.services.CountryOfBirthReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/CountryOfBirth")
@Tag(name = "CountryOfBirthApiResource")
public class CountryOfBirthApiResource {

    private final CountryOfBirthReadPlatformService countryOfBirthReadPlatformService;

    @GetMapping
    public List<CountryOfBirth> fetchAll() {
        return this.countryOfBirthReadPlatformService.fetchAllCountryOfBirth();
    }

    @GetMapping("/{id}")
    public CountryOfBirth fetchCountryOfBirthById(@PathVariable(name = "id") Integer id) {
        return this.countryOfBirthReadPlatformService.fetchCountryOfBirthById(id);
    }
}
