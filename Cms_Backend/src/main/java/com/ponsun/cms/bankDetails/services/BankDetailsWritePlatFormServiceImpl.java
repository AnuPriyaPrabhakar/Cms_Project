package com.ponsun.cms.bankDetails.services;


import com.ponsun.cms.bankDetails.data.BankDetailsData;
import com.ponsun.cms.bankDetails.data.BankDetailsDataValidator;
import com.ponsun.cms.bankDetails.domain.BankDetails;
import com.ponsun.cms.bankDetails.domain.BankDetailsRepository;
import com.ponsun.cms.bankDetails.domain.BankDetailsRepositoryWrapper;
import com.ponsun.cms.bankDetails.request.CreateBankDetailsRequest;
import com.ponsun.cms.bankDetails.request.UpdateBankDetailsRequest;
import com.ponsun.cms.bankDetails.rowmapper.BankDetailsRowMapper;
import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BankDetailsWritePlatFormServiceImpl implements BankDetailsWritePlatFormService {

    private final BankDetailsRepository bankDetailsRepository;
    private final BankDetailsRepositoryWrapper bankDetailsRepositoryWrapper;
    private final BankDetailsDataValidator bankDetailsDataValidator;
    private final BankDetailsRowMapper bankDetailsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
//    public Response createBankDetails(CreateBankDetailsRequest createBankDetailsRequest) {
//        try{
//            this.bankDetailsDataValidator.validateSaveBankDetailsData(createBankDetailsRequest);
//            final BankDetails bankDetails = BankDetails.create(createBankDetailsRequest);
//            this.bankDetailsRepository.saveAndFlush(bankDetails);
//            return Response.of(Long.valueOf(bankDetails.getId()));
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_CMS_AppicationException(e.getMessage());
//        }
//    }

    public Response createBankDetails(CreateBankDetailsRequest createBankDetailsRequest) {
        try {
            final BankDetails bankDetails = BankDetails.create(createBankDetailsRequest);
            this.bankDetailsRepository.saveAndFlush(bankDetails);
            return Response.of(bankDetails.getUid());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateBankDetails(Integer id, UpdateBankDetailsRequest updateBankDetailsRequest) {
        try {
            this.bankDetailsDataValidator.validateUpdateBankDetailsData(updateBankDetailsRequest);
            final BankDetails bankDetails = this.bankDetailsRepositoryWrapper.findOneWithNotFoundDetection(id);
            bankDetails.update(updateBankDetailsRequest);
            this.bankDetailsRepository.saveAndFlush(bankDetails);
            return Response.of(Long.valueOf(bankDetails.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<BankDetailsData> fetchAllBankDetailsData(Integer cmsId) {
        final BankDetailsRowMapper rowMapper = new BankDetailsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cbd.cmsId = ?  AND cbd.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<BankDetailsData> bankDetailsDataList = jdbcTemplate.query(Qry, bankDetailsRowMapper,
                new Object[] {cmsId}
        );
        return bankDetailsDataList;
    }

    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid){
        try{
            List<BankDetails> bankDetails = this.bankDetailsRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (BankDetails bankDetail : bankDetails) {
                bankDetail.setEuid(euid);
                bankDetail.setStatus(Status.DELETE);
                bankDetail.setUpdatedAt(LocalDateTime.now());
                response = Response.of(bankDetail.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}