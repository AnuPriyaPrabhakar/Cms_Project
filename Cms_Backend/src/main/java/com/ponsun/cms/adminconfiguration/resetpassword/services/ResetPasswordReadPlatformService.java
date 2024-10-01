package com.ponsun.cms.adminconfiguration.resetpassword.services;


import com.ponsun.cms.adminconfiguration.resetpassword.domain.ResetPassword;

import java.util.List;

public interface ResetPasswordReadPlatformService {
    ResetPassword fetchResetPasswordById(Integer id);
    List<ResetPassword> fetchAllResetPassword();


}
