package com.ponsun.cms.adminconfiguration.resetpassword.data;


import com.ponsun.cms.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.cms.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResetPasswordDataValidator {
    public void validateSaveResetPassword(final CreateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_CMS_ApplicationException("Password parameter required");
        }
    }
    public void validateUpdateResetPassword(final UpdateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_CMS_ApplicationException("ModuleName parameter required");
        }
    }
}
