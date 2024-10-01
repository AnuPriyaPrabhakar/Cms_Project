package com.ponsun.cms.master.countryOfFlag.api;




import com.ponsun.cms.master.countryOfFlag.domain.CountryOfFlag;
import com.ponsun.cms.master.countryOfFlag.services.CountryOfFlagReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/CountryOfFlag")
@Tag(name = "CountryOfFlagApiResource")
public class CountryOfFlagApiResource {

    private final CountryOfFlagReadPlatformService countryOfFlagReadPlatformService;

    @GetMapping
    public List<CountryOfFlag> fetchAll() {
        return this.countryOfFlagReadPlatformService.fetchAllCountryOfFlag();
    }

    @GetMapping("/{id}")
    public CountryOfFlag fetchCountryOfFlagById(@PathVariable(name = "id") Integer id) {
        return this.countryOfFlagReadPlatformService.fetchCountryOfFlagById(id);
    }
}
