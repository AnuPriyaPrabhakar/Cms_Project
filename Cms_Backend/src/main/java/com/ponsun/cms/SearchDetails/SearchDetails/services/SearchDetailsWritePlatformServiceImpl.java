package com.ponsun.cms.SearchDetails.SearchDetails.services;

import com.ponsun.cms.SearchDetails.SearchDetails.data.SearchDetailsValidator;
import com.ponsun.cms.SearchDetails.SearchDetails.domain.SearchDetails;
import com.ponsun.cms.SearchDetails.SearchDetails.domain.SearchDetailsRepository;
import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchDetailsWritePlatformServiceImpl implements SearchDetailsWritePlatformService {
    private final SearchDetailsRepository searchDetailsRepository;
    private final SearchDetailsValidator searchDetailsValidator;

    @Override
    @Transactional
    public Response createSearchDetails(CreateSearchDetailsRequest createSearchDetailsRequest) {
        try{
            //this.searchDetailsValidator.validateSaveSearchData(createSearchDetailsRequest);
            final SearchDetails searchDetails = SearchDetails.create(createSearchDetailsRequest);
            this.searchDetailsRepository.saveAndFlush(searchDetails);
            return Response.of(Long.valueOf(searchDetails.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
