package com.ponsun.cms.master.RecordType.domain;

import com.ponsun.cms.master.RecordType.request.AbstractRecordTypeRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecordTypeRepositoryWrapper extends AbstractRecordTypeRequest {
    private final RecordTypeRepository recordTypeRepository;
    @Transactional
    public RecordType findOneWithNotFoundDetection(final Integer id){
        return this.recordTypeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RecordType Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
