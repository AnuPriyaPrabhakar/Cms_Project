package com.ponsun.cms.bankDetails.data;



import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.request.UpdateBankDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankDetailsDataValidator {
    public void validateSaveBankDetailsData(final CreateBankDetailsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
    public void validateUpdateBankDetailsData(final UpdateBankDetailsRequest request){
        if(request.getCmsId() == null || request.getCmsId().equals("")){
            throw new EQAS_CMS_ApplicationException("CmsId parameter required");
        }
    }
}
