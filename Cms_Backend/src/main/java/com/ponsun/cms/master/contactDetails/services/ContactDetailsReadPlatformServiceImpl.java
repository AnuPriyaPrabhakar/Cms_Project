package com.ponsun.cms.master.contactDetails.services;



import com.ponsun.cms.master.contactDetails.domain.ContactDetails;
import com.ponsun.cms.master.contactDetails.domain.ContactDetailsRepository;
import com.ponsun.cms.master.contactDetails.domain.ContactDetailsRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactDetailsReadPlatformServiceImpl implements ContactDetailsReadPlatformService {

    private final ContactDetailsRepositoryWrapper contactDetailsRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ContactDetailsRepository contactDetailsRepository;

    @Override
    public ContactDetails fetchContactDetailsById(Integer id) {
        return this.contactDetailsRepository.findById(id).get();
    }
    @Override
    public List<ContactDetails> fetchAllContactDetails() {
        return this.contactDetailsRepository.findAll();
    }

}
