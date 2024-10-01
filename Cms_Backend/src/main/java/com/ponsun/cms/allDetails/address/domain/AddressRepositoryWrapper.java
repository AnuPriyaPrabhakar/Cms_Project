package com.ponsun.cms.allDetails.address.domain;

import com.ponsun.cms.allDetails.address.request.AbstractAddressRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddressRepositoryWrapper extends AbstractAddressRequest {
    private final AddressRepository addressRepository;
    @Transactional
    public Address findOneWithNotFoundDetection(final Integer id){
        return this.addressRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Address Not found" + id));
    }
    @Override
    public String toString(){ return super.toString();}
}
