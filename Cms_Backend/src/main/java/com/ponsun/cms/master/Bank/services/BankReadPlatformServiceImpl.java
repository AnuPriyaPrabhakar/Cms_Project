package com.ponsun.cms.master.Bank.services;



import com.ponsun.cms.master.Bank.domain.Bank;
import com.ponsun.cms.master.Bank.domain.BankRepository;
import com.ponsun.cms.master.Bank.domain.BankRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankReadPlatformServiceImpl implements  BankReadPlatformService{

    private final BankRepositoryWrapper bankRepositoryWrapper;

    private final JdbcTemplate jdbcTemplate;

    private final BankRepository bankRepository;

    @Override
    public Bank fetchBankById(Integer id) {
        return this.bankRepository.findById(id).get();
    }

    @Override
    public List<Bank> fetchAllBank() {
        return this.bankRepository.findAll();
    }

}
