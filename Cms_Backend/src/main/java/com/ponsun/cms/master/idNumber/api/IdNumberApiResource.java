package com.ponsun.cms.master.idNumber.api;





import com.ponsun.cms.master.idNumber.domain.IdNumber;
import com.ponsun.cms.master.idNumber.services.IdNumberReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/IdNumber")
@Tag(name = "IdNumberApiResource")
public class IdNumberApiResource {

    private final IdNumberReadPlatformService idNumberReadPlatformService;

    @GetMapping
    public List<IdNumber> fetchAll() {
        return this.idNumberReadPlatformService.fetchAllIdNumber();
    }

    @GetMapping("/{id}")
    public IdNumber fetchIdNumberById(@PathVariable(name = "id") Integer id) {
        return this.idNumberReadPlatformService.fetchIdNumberById(id);
    }
}
