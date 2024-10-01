package com.ponsun.cms.SearchDetails.SearchDetails.data;


import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SearchDetailsValidator {
    public void validateSaveSearchData(final CreateSearchDetailsRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_CMS_ApplicationException("SearchId parameter required");
        }
    }
}
