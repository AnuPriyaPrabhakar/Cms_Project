package com.ponsun.cms.IndCaseDetails.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IndCaseDetailsRepository extends JpaRepository<IndCaseDetails,Integer> {
    Optional<IndCaseDetails> findById(Integer id);

    List<IndCaseDetails> findByCmsId(Integer cmsId);
}
