package com.ponsun.cms.bankDetails.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BankDetailsRepository extends JpaRepository<BankDetails,Integer> {
    Optional<BankDetails> findById(Integer id);

    List<BankDetails> findByCmsId(Integer cmsId);
}
