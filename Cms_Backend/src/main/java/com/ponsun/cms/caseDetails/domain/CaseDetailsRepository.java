package com.ponsun.cms.caseDetails.domain;


import com.ponsun.cms.common.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CaseDetailsRepository extends JpaRepository<CaseDetails,Integer> {
    Optional<CaseDetails> findById(Integer id);

    List<CaseDetails> findByCmsId(Integer cmsId);
}
