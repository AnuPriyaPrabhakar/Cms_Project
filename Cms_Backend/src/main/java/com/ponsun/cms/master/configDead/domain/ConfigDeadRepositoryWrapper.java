package com.ponsun.cms.master.configDead.domain;

import com.ponsun.cms.master.configDead.request.AbstractConfigDeadRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConfigDeadRepositoryWrapper extends AbstractConfigDeadRequest {
    private final ConfigDeadRepository configDeadRepository;
    @Transactional
    public ConfigDead findOneWithNotFoundDetection(final Integer id){
        return this.configDeadRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ConfigDead Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
