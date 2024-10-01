package com.ponsun.cms.master.contactDetails.domain;




import com.ponsun.cms.master.contactDetails.request.AbstractContactDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ContactDetailsRepositoryWrapper extends AbstractContactDetailsRequest {
    private final ContactDetailsRepository contactDetailsRepository;

    @Transactional
    public ContactDetails findOneWithNotFoundDetection(final Integer id) {
        return this.contactDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CountryOfBirth Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
