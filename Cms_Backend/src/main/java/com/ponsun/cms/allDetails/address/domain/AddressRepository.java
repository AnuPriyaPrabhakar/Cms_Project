package com.ponsun.cms.allDetails.address.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Optional<Address> findById(Integer id);
}
