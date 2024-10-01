package com.ponsun.cms.master.RecordType.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecordTypeRepository extends JpaRepository<RecordType,Integer> {
    Optional<RecordType> findById(Integer id);
}