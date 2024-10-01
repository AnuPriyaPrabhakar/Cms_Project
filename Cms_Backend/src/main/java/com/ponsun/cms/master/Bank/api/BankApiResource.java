package com.ponsun.cms.master.Bank.api;


import com.ponsun.cms.master.Bank.domain.Bank;
import com.ponsun.cms.master.Bank.services.BankReadPlatformService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/Bank")
@Tag(name = "BankApiResource")
public class BankApiResource {

    private final BankReadPlatformService bankReadPlatformService;

    @GetMapping
    public List<Bank> fetchAll() {
        return this.bankReadPlatformService.fetchAllBank();
    }

    @GetMapping("/{id}")
    public Bank fetchBankById(@PathVariable(name = "id") Integer id) {
        return this.bankReadPlatformService.fetchBankById(id);
    }
}
