package com.ponsun.cms.IndOrg.relationAliases.domain;



import com.ponsun.cms.IndOrg.relationAliases.request.AbstractRelationAliasesRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RelationAliasesRepositoryWrapper extends AbstractRelationAliasesRequest {
    private final RelationAliasesRepository relationAliasesRepository;

    @Transactional
    public RelationAliases findOneWithNotFoundDetection(final Integer id){
        return this.relationAliasesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RelationAliases Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
