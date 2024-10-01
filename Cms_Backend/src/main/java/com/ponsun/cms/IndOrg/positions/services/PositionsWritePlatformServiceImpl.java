package com.ponsun.cms.IndOrg.positions.services;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.PositionsDTO;
import com.ponsun.cms.IndOrg.positions.data.PositionsDataValidator;
import com.ponsun.cms.IndOrg.positions.domain.Positions;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepository;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepositoryWrapper;
import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.request.UpdatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.rowmapper.PositionsRowMapper;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PositionsWritePlatformServiceImpl implements  PositionsWritePlatformService {

    private final PositionsRepository positionsRepository;
    private final PositionsRepositoryWrapper positionsRepositoryWrapper;
    private final PositionsDataValidator positionsDataValidator;
    private final PositionsRowMapper positionsRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createPositions(CreatePositionsRequest createPositionsRequest) {
        try{
            this.positionsDataValidator.validateSavePositionsData(createPositionsRequest);
            final Positions positions = Positions.create(createPositionsRequest);
            this.positionsRepository.saveAndFlush(positions);
            return Response.of(positions.getId());
        }catch (DataIntegrityViolationException e){
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updatePositions(Integer id, UpdatePositionsRequest updatePositionsRequest) {
        try {
            this.positionsDataValidator.validateUpdatePositionsData(updatePositionsRequest);
            final Positions positions = this.positionsRepositoryWrapper.findOneWithNotFoundDetection(id);
            positions.update(updatePositionsRequest);
            this.positionsRepository.saveAndFlush(positions);
            return Response.of(Long.valueOf(positions.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public List<PositionsDTO> fetchPositionsDTO(Integer cmsId) {
        final PositionsRowMapper rowMapper = new PositionsRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE position.cmsId = ?  AND position.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<PositionsDTO> positionsDTOList  = jdbcTemplate.query(Qry,positionsRowMapper,
                new Object[] {cmsId}
        );
        return positionsDTOList;
    }


//    @Override
//    @Transactional
//    public Response DeActiveIndOrg(Integer cmsId, Integer recordTypeId, Integer euid){
//        try {
//            updatePosition(cmsId, recordTypeId, euid);
//            updateIndAliasesName(cmsId, recordTypeId, euid);
//            updateRelation(cmsId, recordTypeId, euid);
//            updateRelationAliasesName(cmsId, recordTypeId, euid);
//            updateDetailsAboutRelation(cmsId, recordTypeId, euid);
//            System.out.println("updateRelationAliasesName:"+cmsId+recordTypeId);
//            return new Response("Records deactivated successfully.");
//        } catch (DataIntegrityViolationException e) {
//            throw new EQAS_CMS_AppicationException("Error deactivating records: " + e.getMessage());
//        }
//    }
//
//    public void updatePosition(Integer cmsId,Integer recordTypeId , Integer euid) {
//        String sql = "UPDATE cms_position  SET STATUS='D',euid= ?,updated_at=now() WHERE cmsId= ? AND recordTypeId = ?";
//        jdbcTemplate.update(sql, euid, cmsId,recordTypeId);
//    }
//
////    private Integer getPositionId(Integer cmsId , Integer recordTypeId) {
////        String selectQuery = "SELECT id FROM cms_position WHERE cmsId=? AND recordTypeId = ? AND STATUS = 'A' LIMIT 1";
////        return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, cmsId , recordTypeId);
////    }
//
//    private Integer getPositionId(Integer cmsId ) {
//        String selectQuery = "SELECT id FROM cms_position WHERE cmsId=? AND STATUS = 'A' LIMIT 1";
//
//        try {
//            return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, cmsId);
//        } catch (EmptyResultDataAccessException e) {
//            return null;
//        }
//    }
//
//
//    public void updateIndAliasesName(Integer cmsId , Integer recordTypeId , Integer euid) {
//        Integer positionId = getPositionId(cmsId);
//        String updateQuery = "UPDATE cms_individual_aliases_name SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? AND recordTypeId = ?";
////        System.out.println("positionId :"+positionId);
////        System.out.println("cmsId :"+cmsId);
////        System.out.println("recordTypeId :"+recordTypeId);
////        System.out.println("updateQuery :"+updateQuery);
//        this.jdbcTemplate.update(updateQuery, euid, cmsId, positionId , recordTypeId);
//    }
//
//    public void updateRelation(Integer cmsId, Integer recordTypeId, Integer euid) {
//        Integer positionId = getPositionId(cmsId);
//        System.out.println("positionId:"+positionId);
//        System.out.println("recordTypeId:"+recordTypeId);
//        System.out.println("cmsId:"+cmsId);
//        String str = " UPDATE cms_relations SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? AND recordTypeId = ?";
//        this.jdbcTemplate.update(str, euid, cmsId, positionId, recordTypeId);
//    }
//
//    public void updateRelationAliasesName(Integer cmsId, Integer recordTypeId , Integer euid) {
//        Integer positionId = getPositionId(cmsId);
////        System.out.println("positionId:"+positionId);
//        String str = "UPDATE cms_relation_aliases_name SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? AND recordTypeId = ? ";
//        this.jdbcTemplate.update(str, euid, cmsId, positionId,recordTypeId);
//    }
//
//    public void updateDetailsAboutRelation(Integer cmsId, Integer recordTypeId , Integer euid) {
//        Integer positionId = getPositionId(cmsId);
////        System.out.println("positionId:"+positionId);
//        String str = "UPDATE cms_details_about_relation SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? AND recordTypeId = ? ";
//        this.jdbcTemplate.update(str, euid, cmsId, positionId,recordTypeId);
//    }


    @Override
    @Transactional
    public Response DeActiveIndOrg(Integer cmsId, Integer euid){
        try {
            updatePosition(cmsId, euid);
            updateIndAliasesName(cmsId, euid);
            updateRelation(cmsId, euid);
            updateRelationAliasesName(cmsId, euid);
            updateDetailsAboutRelation(cmsId, euid);
            return new Response("Records deactivated successfully.");
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException("Error deactivating records: " + e.getMessage());
        }
    }

    public void updatePosition(Integer cmsId, Integer euid) {
        String sql = "UPDATE cms_position  SET STATUS='D',euid= ?,updated_at=now() WHERE cmsId= ? ";
        jdbcTemplate.update(sql, euid, cmsId);
    }

//    private Integer getPositionId(Integer cmsId , Integer recordTypeId) {
//        String selectQuery = "SELECT id FROM cms_position WHERE cmsId=? AND recordTypeId = ? AND STATUS = 'A' LIMIT 1";
//        return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, cmsId , recordTypeId);
//    }

    private Integer getPositionId(Integer cmsId ) {
        String selectQuery = "SELECT id FROM cms_position WHERE cmsId=? AND STATUS = 'A' LIMIT 1";

        try {
            return this.jdbcTemplate.queryForObject(selectQuery, Integer.class, cmsId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public void updateIndAliasesName(Integer cmsId  , Integer euid) {
        Integer positionId = getPositionId(cmsId);
        String updateQuery = "UPDATE cms_individual_aliases_name SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? ";
//        System.out.println("positionId :"+positionId);
//        System.out.println("cmsId :"+cmsId);
//        System.out.println("recordTypeId :"+recordTypeId);
//        System.out.println("updateQuery :"+updateQuery);
        this.jdbcTemplate.update(updateQuery, euid, cmsId, positionId );
    }

    public void updateRelation(Integer cmsId, Integer euid) {
        Integer positionId = getPositionId(cmsId);
        System.out.println("positionId:"+positionId);
        System.out.println("cmsId:"+cmsId);
        String str = " UPDATE cms_relations SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=? ";
        this.jdbcTemplate.update(str, euid, cmsId, positionId);
    }

    public void updateRelationAliasesName(Integer cmsId, Integer euid) {
        Integer positionId = getPositionId(cmsId);
//        System.out.println("positionId:"+positionId);
        String str = "UPDATE cms_relation_aliases_name SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=?  ";
        this.jdbcTemplate.update(str, euid, cmsId, positionId);
    }

    public void updateDetailsAboutRelation(Integer cmsId , Integer euid) {
        Integer positionId = getPositionId(cmsId);
//        System.out.println("positionId:"+positionId);
        String str = "UPDATE cms_details_about_relation SET STATUS='D', euid=?, updated_at=NOW() WHERE cmsId=? AND positionId=?  ";
        this.jdbcTemplate.update(str, euid, cmsId, positionId);
    }


}
