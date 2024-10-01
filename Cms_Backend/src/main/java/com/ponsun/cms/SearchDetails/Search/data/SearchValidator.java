package com.ponsun.cms.SearchDetails.Search.data;


import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchValidator {
    public void validateSaveSearchData(final CreateSearchRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_CMS_ApplicationException("SearchId parameter required");
        }
    }
}
