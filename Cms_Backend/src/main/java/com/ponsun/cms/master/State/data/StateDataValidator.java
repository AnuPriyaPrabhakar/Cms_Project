package com.ponsun.cms.master.State.data;

import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.master.State.request.CreateStateRequest;
import com.ponsun.cms.master.State.request.UpdateStateRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StateDataValidator {
    public void validatesaveStateData(final CreateStateRequest request){
        if(request.getStateName() == null || request.getStateName().equals("")){
            throw new EQAS_CMS_ApplicationException("StateName parameter required");
        }
    }
    public void validateUpdateStateData(final UpdateStateRequest request){
        if(request.getStateName() == null || request.getStateName().equals("")){
            throw new EQAS_CMS_ApplicationException("StateName parameter required");
        }
    }
}
