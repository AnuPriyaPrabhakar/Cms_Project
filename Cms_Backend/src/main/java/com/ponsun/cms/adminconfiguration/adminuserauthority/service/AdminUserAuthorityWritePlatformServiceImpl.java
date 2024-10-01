package com.ponsun.cms.adminconfiguration.adminuserauthority.service;



import com.ponsun.cms.adminconfiguration.adminuserauthority.data.AdminUserAuthorityDataValidator;
import com.ponsun.cms.adminconfiguration.adminuserauthority.domain.AdminUserAuthority;
import com.ponsun.cms.adminconfiguration.adminuserauthority.domain.AdminUserAuthorityRepository;
import com.ponsun.cms.adminconfiguration.adminuserauthority.domain.AdminUserAuthorityRepositoryWrapper;
import com.ponsun.cms.adminconfiguration.adminuserauthority.request.CreateAdminUserAuthorityRequest;
import com.ponsun.cms.adminconfiguration.adminuserauthority.request.UpdateAdminUserAuthorityRequest;
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
public class AdminUserAuthorityWritePlatformServiceImpl implements AdminUserAuthorityWritePlatformService {
    private final AdminUserAuthorityRepository adminUserAuthorityRepository;
    private final AdminUserAuthorityRepositoryWrapper adminUserAuthorityRepositoryWrapper;
private final AdminUserAuthorityDataValidator adminUserAuthorityDataValidator;
    @Override
    @Transactional

    public Response createAdminUserAuthority(CreateAdminUserAuthorityRequest createAdminUserAuthorityRequest){
        try{
            this.adminUserAuthorityDataValidator.validateSaveAdminUserAuthority(createAdminUserAuthorityRequest);
            final AdminUserAuthority adminUserAuthority = AdminUserAuthority.create(createAdminUserAuthorityRequest);
            this.adminUserAuthorityRepository.saveAndFlush(adminUserAuthority);
            return Response.of(Long.valueOf(adminUserAuthority.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAdminUserAuthority(Integer id, UpdateAdminUserAuthorityRequest updateAdminUserAuthorityRequest) {
        try {
            this.adminUserAuthorityDataValidator.validateUpdateAdminUserAuthority(updateAdminUserAuthorityRequest);
            final AdminUserAuthority adminUserAuthority = this.adminUserAuthorityRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminUserAuthority.update(updateAdminUserAuthorityRequest);
            this.adminUserAuthorityRepository.saveAndFlush(adminUserAuthority);
            return Response.of(Long.valueOf(adminUserAuthority.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response blockAdminUserAuthority(Integer id) {
        try {
            final AdminUserAuthority adminUserAuthority = this.adminUserAuthorityRepositoryWrapper.findOneWithNotFoundDetection(id);
           adminUserAuthority.setValid(false);
            adminUserAuthority.setStatus(Status.DELETE);
            adminUserAuthority.setUpdatedAt(LocalDateTime.now());
            this.adminUserAuthorityRepository.saveAndFlush(adminUserAuthority);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response unblockAdminUserAuthority(Integer id) {
        try {
            final AdminUserAuthority adminUserAuthority = this.adminUserAuthorityRepositoryWrapper.findOneWithNotFoundDetection(id);
            adminUserAuthority.setValid(true);
            adminUserAuthority.setStatus(Status.ACTIVE);
            adminUserAuthority.setUpdatedAt(LocalDateTime.now());
            this.adminUserAuthorityRepository.saveAndFlush(adminUserAuthority);
            return Response.of(Long.valueOf(id));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
