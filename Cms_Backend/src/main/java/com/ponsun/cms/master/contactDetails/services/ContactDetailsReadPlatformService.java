package com.ponsun.cms.master.contactDetails.services;


import com.ponsun.cms.master.contactDetails.domain.ContactDetails;

import java.util.List;

public interface ContactDetailsReadPlatformService {

    List<ContactDetails> fetchAllContactDetails();

    ContactDetails fetchContactDetailsById(Integer id);
}
