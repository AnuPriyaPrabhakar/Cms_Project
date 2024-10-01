package com.ponsun.cms.master.Bank.domain;




import com.ponsun.cms.master.Bank.request.AbstractBankRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BankRepositoryWrapper extends AbstractBankRequest {
    private final BankRepository bankRepository;

    @Transactional
    public Bank findOneWithNotFoundDetection(final Integer id) {
        return this.bankRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bank Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
