package com.ponsun.cms.infrastructure.exceptions;

public class EQAS_CMS_ApplicationException extends AbstractPlatformException{

    public EQAS_CMS_ApplicationException(String message){
        super("error.msg.generic",message);
    }
}
