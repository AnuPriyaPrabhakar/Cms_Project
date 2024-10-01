package com.ponsun.cms.company.companyAliases.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyAliasesRepository extends JpaRepository<CompanyAliases,Integer> {
    Optional<CompanyAliases> findById(Integer id);

    List<CompanyAliases> findByCmsId(Integer cmsId);
}
