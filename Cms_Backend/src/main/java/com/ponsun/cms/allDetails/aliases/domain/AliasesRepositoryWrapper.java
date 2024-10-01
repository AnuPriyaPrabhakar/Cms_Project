package com.ponsun.cms.allDetails.aliases.domain;

import com.ponsun.cms.allDetails.aliases.request.AbstractAliasesRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AliasesRepositoryWrapper extends AbstractAliasesRequest {
    private final AliasesRepository aliasesRepository;
    @Transactional
    public Aliases findOneWithNotFoundDetection(final Integer id){
        return this.aliasesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Aliases Not found" + id));
    }
    @Override
    public String toString(){ return super.toString();}

}
