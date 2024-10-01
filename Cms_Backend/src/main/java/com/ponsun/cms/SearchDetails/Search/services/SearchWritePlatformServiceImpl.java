package com.ponsun.cms.SearchDetails.Search.services;

import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import com.ponsun.cms.SearchDetails.Search.data.SearchValidator;
import com.ponsun.cms.SearchDetails.Search.domain.Search;
import com.ponsun.cms.SearchDetails.Search.domain.SearchRepository;
import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
@Slf4j

public class SearchWritePlatformServiceImpl implements SearchWritePlatformService {
    private final SearchRepository searchRepository;
    private final SearchValidator searchValidator;
    @Override
    @Transactional
    public Response createSearch (CreateSearchRequest createSearchRequest) {
        try {
            //this.searchValidator.validateSaveSearchData(createSearchRequest);
            Search search = Search.create(createSearchRequest);
            search= this.searchRepository.saveAndFlush(search);
            //return Response.of(Long.valueOf(search.getId()));
            return new Response(search.getId());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
