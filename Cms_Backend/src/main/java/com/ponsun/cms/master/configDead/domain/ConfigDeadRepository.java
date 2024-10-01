package com.ponsun.cms.master.configDead.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigDeadRepository extends JpaRepository<ConfigDead,Integer> {
    Optional<ConfigDead> findById(Integer id);
}
