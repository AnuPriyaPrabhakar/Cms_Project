package com.ponsun.cms.bankDetails.services;

import com.ponsun.cms.bankDetails.domain.BankDetails;

import java.util.List;

public interface BankDetailsReadPlatFormService {
    List<BankDetails> fetchAllBankDetails();
    BankDetails fetchBankDetailsById(Integer id);
}
