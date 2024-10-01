package com.ponsun.cms.bankDetails.services;

import com.ponsun.cms.bankDetails.data.BankDetailsData;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.request.UpdateBankDetailsRequest;
import com.ponsun.cms.infrastructure.utils.Response;

import java.util.List;

public interface BankDetailsWritePlatFormService {


    Response deactive(Integer cmsId, Integer euid);

    Response createBankDetails(CreateBankDetailsRequest createBankDetailsRequest);

    List<BankDetailsData> fetchAllBankDetailsData(Integer cmsId);

    Response updateBankDetails(Integer id, UpdateBankDetailsRequest updateAliasesNameRequest);
}
