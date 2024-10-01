package com.ponsun.cms.master.countryOfFlag.domain;



import com.ponsun.cms.master.countryOfFlag.request.AbstractCountryOfFlagRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryOfFlagRepositoryWrapper extends AbstractCountryOfFlagRequest {
    private final CountryOfFlagRepository countryOfFlagRepository;

    @Transactional
    public CountryOfFlag findOneWithNotFoundDetection(final Integer id) {
        return this.countryOfFlagRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CountryOfFlag Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
