package com.ponsun.cms.master.countryOfBirth.domain;

import com.ponsun.cms.master.countryOfBirth.request.AbstractCountryOfBirthRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CountryOfBirthRepositoryWrapper extends AbstractCountryOfBirthRequest {
    private final CountryOfBirthRepository countryOfBirthRepository;

    @Transactional
    public CountryOfBirth findOneWithNotFoundDetection(final Integer id) {
        return this.countryOfBirthRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CountryOfBirth Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
