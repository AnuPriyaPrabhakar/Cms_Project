package com.ponsun.cms.SearchDetails.SearchDetails.domain;


import com.ponsun.cms.SearchDetails.SearchDetails.request.AbstractSearchDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SearchDetailsRepositoryWrapperDetails extends AbstractSearchDetailsRequest {
    private final SearchDetailsRepository SearchDetailsRepository;

    @Transactional
    public SearchDetails findOneWithNotFoundDetection(final Integer id) {
        return this.SearchDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ConfigSearch Not found" + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
