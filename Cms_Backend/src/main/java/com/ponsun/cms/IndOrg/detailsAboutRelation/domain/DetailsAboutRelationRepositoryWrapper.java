package com.ponsun.cms.IndOrg.detailsAboutRelation.domain;


import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepository;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.AbstractDetailsAboutRelationRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DetailsAboutRelationRepositoryWrapper extends AbstractDetailsAboutRelationRequest {
    private final DetailsAboutRelationRepository detailsAboutRelationRepository;


    @Transactional
    public DetailsAboutRelation findOneWithNotFoundDetection(final Integer id){
        return this.detailsAboutRelationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("DetailsAboutRelation Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
