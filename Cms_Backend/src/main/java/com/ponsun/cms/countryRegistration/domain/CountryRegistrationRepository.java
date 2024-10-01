package com.ponsun.cms.countryRegistration.domain;


import com.ponsun.cms.common.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRegistrationRepository extends JpaRepository<CountryRegistration,Integer> {
    Optional<CountryRegistration> findById(Integer id);
    List<CountryRegistration> findByCmsId(Integer cmsId);
}
