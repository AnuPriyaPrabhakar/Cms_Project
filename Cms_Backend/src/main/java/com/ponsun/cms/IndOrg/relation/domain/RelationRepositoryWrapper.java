package com.ponsun.cms.IndOrg.relation.domain;

import com.ponsun.cms.IndOrg.relation.request.AbstractRelationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RelationRepositoryWrapper extends AbstractRelationRequest {
    private final RelationRepository relationRepository;

    @Transactional
    public Relation findOneWithNotFoundDetection(final Integer id){
        return this.relationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Relation Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
