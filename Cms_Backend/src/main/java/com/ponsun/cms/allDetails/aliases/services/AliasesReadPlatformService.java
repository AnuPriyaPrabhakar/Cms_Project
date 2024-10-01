package com.ponsun.cms.allDetails.aliases.services;

import com.ponsun.cms.allDetails.aliases.domain.Aliases;

import java.util.List;
public interface AliasesReadPlatformService {
    Aliases fetchAliasesById(Integer id);
    List<Aliases> fetchAllAliases();
}
