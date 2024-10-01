package com.ponsun.cms.master.Bank.services;



import com.ponsun.cms.master.Bank.domain.Bank;

import java.util.List;

public interface BankReadPlatformService {
    List<Bank> fetchAllBank();

    Bank fetchBankById(Integer id);
}
