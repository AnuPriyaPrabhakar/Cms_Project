package com.ponsun.cms.master.idNumber.domain;

import com.ponsun.cms.master.idNumber.request.AbstractIdNumberRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IdNumberRepositoryWrapper extends AbstractIdNumberRequest {
    private final IdNumberRepository IdNumberRepository;

    @Transactional
    public IdNumber findOneWithNotFoundDetection(final Integer id) {
        return this.IdNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("IdNumber Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
