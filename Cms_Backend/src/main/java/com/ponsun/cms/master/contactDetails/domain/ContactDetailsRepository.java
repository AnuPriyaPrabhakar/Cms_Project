package com.ponsun.cms.master.contactDetails.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Integer> {
    Optional<ContactDetails> findById(Integer id);
}
