package com.ponsun.cms.adminconfiguration.resetpassword.services;


import com.ponsun.cms.adminconfiguration.resetpassword.data.ResetPasswordDataValidator;
import com.ponsun.cms.adminconfiguration.resetpassword.domain.ResetPassword;
import com.ponsun.cms.adminconfiguration.resetpassword.domain.ResetPasswordRepository;
import com.ponsun.cms.adminconfiguration.resetpassword.domain.ResetPasswordRepositoryWrapper;
import com.ponsun.cms.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.cms.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResetPasswordWritePlatformServiceImpl implements ResetPasswordWritePlatformService {

    private final ResetPasswordRepository resetpasswordRepository;
    private  final ResetPasswordRepositoryWrapper resetpasswordRepositoryWrapper;
    private  final ResetPasswordDataValidator resetPasswordDataValidator;

    @Override
    @Transactional
    public Response createResetPassword(CreateResetPasswordRequest createResetPasswordRequest) {

        try {
            this.resetPasswordDataValidator.validateSaveResetPassword(createResetPasswordRequest);
            final ResetPassword resetPassword = ResetPassword.create(createResetPasswordRequest);//entity
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(resetPassword.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateResetPassword(Integer id, UpdateResetPasswordRequest updateResetPasswordRequest) {
        try {
            this.resetPasswordDataValidator.validateUpdateResetPassword(updateResetPasswordRequest);
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.update(updateResetPasswordRequest);
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(resetPassword.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockResetPassword(Integer id) {
        try {
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.setValid(false);
            resetPassword.setStatus(Status.DELETE);
            resetPassword.setUpdatedAt(LocalDateTime.now());
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response unblockResetPassword(Integer id) {
        try {
            final ResetPassword resetPassword = this.resetpasswordRepositoryWrapper.findOneWithNotFoundDetection(id);
            resetPassword.setValid(true);
            resetPassword.setStatus(Status.ACTIVE);
            resetPassword.setUpdatedAt(LocalDateTime.now());
            this.resetpasswordRepository.saveAndFlush(resetPassword);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
