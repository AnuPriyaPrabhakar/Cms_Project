package com.ponsun.cms.IndOrg.indAliasesName.services;

import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesName;

import java.util.List;

public interface IndAliasesNameReadPlatformService {
    IndAliasesName fetchIndAliasesNameById(Integer id);

    List<IndAliasesName> fetchAllIndAliasesName();
}
