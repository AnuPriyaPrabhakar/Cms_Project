package com.ponsun.cms.bankDetails.domain;


import com.ponsun.cms.bankDetails.request.AbstractBankDetailsRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankDetailsRepositoryWrapper extends AbstractBankDetailsRequest {
    private final BankDetailsRepository bankDetailsRepository;


    @Transactional
    public BankDetails findOneWithNotFoundDetection(final Integer id){
        return this.bankDetailsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("BankDetails Not found" + id));
    }

    @Transactional
    public List<BankDetails> findCmsIdNotFoundDetection(final Integer cmsId){
        return this.bankDetailsRepository.findByCmsId(cmsId);
    }

    @Override
    public String toString(){ return super.toString();}
}
