package com.ponsun.cms.company.companyDetails.domain;


import com.ponsun.cms.common.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails,Integer> {
    Optional<CompanyDetails> findById(Integer id);

    List<CompanyDetails> findByCmsId(Integer cmsId);

    List<CompanyDetails> findByCmsIdAndStatus(Integer cmsId, Status status);
}
