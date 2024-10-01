package com.ponsun.cms.allDetails.dateOfBirth.services;

import com.ponsun.cms.allDetails.CombinedServices.writeDTO.DateOfBirthDTO;
import com.ponsun.cms.allDetails.dateOfBirth.data.DateOfBirthDataValidator;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirth;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepository;
import com.ponsun.cms.allDetails.dateOfBirth.domain.DateOfBirthRepositoryWrapper;
import com.ponsun.cms.allDetails.dateOfBirth.request.CreateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.request.UpdateDateOfBirthRequest;
import com.ponsun.cms.allDetails.dateOfBirth.rowmapper.DateOfBirthRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DateOfBirthWritePlatformServiceImpl implements DateOfBirthWritePlatformService {
    private final DateOfBirthRepository dateOfBirthRepository;
    private final DateOfBirthRepositoryWrapper dateOfBirthRepositoryWrapper;
    private final DateOfBirthDataValidator dateOfBirthDataValidator;
    private final DateOfBirthRowMapper dateOfBirthRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Transactional
    public Response createDateOfBirth(CreateDateOfBirthRequest createDateOfBirthRequest){
        try{
            this.dateOfBirthDataValidator.validateSaveDateOfBirthData(createDateOfBirthRequest);
            final DateOfBirth dateOfBirth = DateOfBirth.create(createDateOfBirthRequest);
            this.dateOfBirthRepository.saveAndFlush(dateOfBirth);
            return Response.of(Long.valueOf(dateOfBirth.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateDateOfBirth(Integer id, UpdateDateOfBirthRequest updateDateOfBirthRequest) {
        try {
            this.dateOfBirthDataValidator.validateUpdateDateOfBirthData(updateDateOfBirthRequest);
            final DateOfBirth dateOfBirth = this.dateOfBirthRepositoryWrapper.findOneWithNotFoundDetection(id);
            dateOfBirth.update(updateDateOfBirthRequest);
            this.dateOfBirthRepository.saveAndFlush(dateOfBirth);
            return Response.of(Long.valueOf(dateOfBirth.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<DateOfBirthDTO> fetchAllDateOfBirthDTO(Integer cmsId) {
        final DateOfBirthRowMapper rowMapper = new DateOfBirthRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cd.cmsId = ?  AND cd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<DateOfBirthDTO> dateOfBirthDTOList  = jdbcTemplate.query(Qry,dateOfBirthRowMapper,
                new Object[] {cmsId}
        );
        return dateOfBirthDTOList;
    }
}
