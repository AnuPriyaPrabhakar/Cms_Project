package com.ponsun.cms.IndOrg.indAliasesName.domain;


import com.ponsun.cms.IndOrg.indAliasesName.request.AbstractIndAliasesNameRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class IndAliasesNameRepositoryWrapper extends AbstractIndAliasesNameRequest {
    private final IndAliasesNameRepository IndAliasesNameRepository;


    @Transactional
    public IndAliasesName findOneWithNotFoundDetection(final Integer id){
        return this.IndAliasesNameRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("IndAliasesName Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
