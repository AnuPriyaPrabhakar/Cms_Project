package com.ponsun.cms.master.contactDetails.api;

import com.ponsun.cms.master.contactDetails.domain.ContactDetails;
import com.ponsun.cms.master.contactDetails.services.ContactDetailsReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/ContactDetails")
@Tag(name = "ContactDetailsApiResource")
public class ContactDetailsApiResource {

    private final ContactDetailsReadPlatformService contactDetailsReadPlatformService;

    @GetMapping
    public List<ContactDetails> fetchAll() {
        return this.contactDetailsReadPlatformService.fetchAllContactDetails();
    }

    @GetMapping("/{id}")
    public ContactDetails fetchContactDetailsById(@PathVariable(name = "id") Integer id) {
        return this.contactDetailsReadPlatformService.fetchContactDetailsById(id);
    }
}
