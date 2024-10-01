package com.ponsun.cms.adminconfiguration.adminuserauthority.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminUserAuthorityRepository extends JpaRepository<AdminUserAuthority, Integer> {
    Optional<AdminUserAuthority> findById(Integer id);

}