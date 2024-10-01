package com.ponsun.cms.IndPositions.services;



import com.ponsun.cms.IndPositions.data.IndPositionsData;
import com.ponsun.cms.IndPositions.data.IndPositionsDataValidator;
import com.ponsun.cms.IndPositions.domain.IndPositions;
import com.ponsun.cms.IndPositions.domain.IndPositionsRepository;
import com.ponsun.cms.IndPositions.domain.IndPositionsRepositoryWrapper;
import com.ponsun.cms.IndPositions.request.CreateIndPositionsRequest;
import com.ponsun.cms.IndPositions.request.UpdateIndPositionsRequest;
import com.ponsun.cms.IndPositions.rowmapper.IndPositionsRowMapper;
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
public class IndPositionsWritePlatformServiceImpl implements IndPositionsWritePlatformService {

    private final IndPositionsRepository indPositionsRepository;
    private final IndPositionsRepositoryWrapper indPositionsRepositoryWrapper;
    private final IndPositionsDataValidator indPositionsDataValidator;
    private final IndPositionsRowMapper indPositionsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
//    public Response createIndPositions(CreateIndPositionsRequest createIndPositionsRequest) {
//        try{
//            this.indPositionsDataValidator.validateSaveIndPositionsData(createIndPositionsRequest);
//            final IndPositions indPositions = IndPositions.create(createIndPositionsRequest);
//            this.indPositionsRepository.saveAndFlush(indPositions);
//            return Response.of(indPositions.getId());
//        }catch (DataIntegrityViolationException e){
//            throw new EQAS_CMS_AppicationException(e.getMessage());
//        }
//    }

    public Response createIndPositions(CreateIndPositionsRequest createIndPositionsRequest) {
        try {
            final IndPositions indPositions = IndPositions.create(createIndPositionsRequest);
            this.indPositionsRepository.saveAndFlush(indPositions);
            return Response.of(indPositions.getUid());
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateIndPositions(Integer id, UpdateIndPositionsRequest updateIndPositionsRequest) {
        try {
            this.indPositionsDataValidator.validateUpdateIndPositionsData(updateIndPositionsRequest);
            final IndPositions indPositions = this.indPositionsRepositoryWrapper.findOneWithNotFoundDetection(id);
            indPositions.update(updateIndPositionsRequest);
            this.indPositionsRepository.saveAndFlush(indPositions);
            return Response.of(Long.valueOf(indPositions.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<IndPositionsData> fetchIndPositionsData(Integer cmsId) {
        final IndPositionsRowMapper rowMapper = new IndPositionsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ip.cmsId = ?  AND ip.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<IndPositionsData> indPositionsData  = jdbcTemplate.query(Qry,indPositionsRowMapper,
                new Object[] {cmsId }
        );
        return indPositionsData;
    }

    @Override
    @Transactional
    public Response deactive(Integer cmsId, Integer euid){
        try{
            List<IndPositions> indPositions = this.indPositionsRepositoryWrapper.findCmsIdNotFoundDetection(cmsId);
            Response response = null;
            for (IndPositions indPosition : indPositions) {
                indPosition.setEuid(euid);
                indPosition.setStatus(Status.DELETE);
                indPosition.setUpdatedAt(LocalDateTime.now());
                response = Response.of(indPosition.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
