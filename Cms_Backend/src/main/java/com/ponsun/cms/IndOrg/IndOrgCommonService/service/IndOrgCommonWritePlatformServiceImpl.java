package com.ponsun.cms.IndOrg.IndOrgCommonService.service;

import com.ponsun.cms.IndOrg.IndOrgCommonService.dto.*;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelation;
import com.ponsun.cms.IndOrg.detailsAboutRelation.domain.DetailsAboutRelationRepository;
import com.ponsun.cms.IndOrg.detailsAboutRelation.request.CreateDetailsAboutRelationRequest;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesName;
import com.ponsun.cms.IndOrg.indAliasesName.domain.IndAliasesNameRepository;
import com.ponsun.cms.IndOrg.indAliasesName.request.CreateIndAliasesNameRequest;
import com.ponsun.cms.IndOrg.positions.domain.Positions;
import com.ponsun.cms.IndOrg.positions.domain.PositionsRepository;
import com.ponsun.cms.IndOrg.positions.request.CreatePositionsRequest;
import com.ponsun.cms.IndOrg.positions.services.PositionsWritePlatformService;
import com.ponsun.cms.IndOrg.relation.domain.Relation;
import com.ponsun.cms.IndOrg.relation.domain.RelationRepository;
import com.ponsun.cms.IndOrg.relation.request.CreateRelationRequest;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliases;
import com.ponsun.cms.IndOrg.relationAliases.domain.RelationAliasesRepository;
import com.ponsun.cms.IndOrg.relationAliases.request.CreateRelationAliasesRequest;
import com.ponsun.cms.infrastructure.exceptions.EQAS_CMS_ApplicationException;
import com.ponsun.cms.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndOrgCommonWritePlatformServiceImpl implements IndOrgCommonWritePlatformService {

    private final PositionsRepository positionsRepository;
    private final IndAliasesNameRepository indAliasesNameRepository;
    private final RelationRepository relationRepository;
    private final RelationAliasesRepository relationAliasesRepository;
    private final DetailsAboutRelationRepository detailsAboutRelationRepository;
    private final PositionsWritePlatformService positionsWritePlatformService;

    @Override
    public Response createIndOrgDetails(Integer cmsId, List<IndOrgCommonDTO> indOrgCommonDTOS) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            for (IndOrgCommonDTO dto : indOrgCommonDTOS) {
                CreatePositionsRequest request = modelMapper.map(dto.getPositionsDTO(), CreatePositionsRequest.class);
                final Positions positions = Positions.create(request);
//                if (!positions.getLinIndName().isEmpty()) {
                    positions.setCmsId(cmsId);
                    this.positionsRepository.save(positions);
                    int detId = positions.getId();
                    response = Response.of(positions.getId());

                    for (IndAliasesNameDTO indAliasesNameDTO : dto.getIndAliasesNameDTOS()) {
                        CreateIndAliasesNameRequest createIndAliasesNameRequest = modelMapper.map(indAliasesNameDTO, CreateIndAliasesNameRequest.class);
                        if(!createIndAliasesNameRequest.getLinIndAliasesName().isEmpty()) {
                            createIndAliasesNameRequest.setPositionId(detId);
                            createIndAliasesNameRequest.setCmsId(cmsId);
                            final IndAliasesName indAliasesName = IndAliasesName.create(createIndAliasesNameRequest);
                            this.indAliasesNameRepository.save(indAliasesName);
                        }

                    }
                    for (RelationDTO relationDTO : dto.getRelationDTOS()) {
                        CreateRelationRequest createRelationRequest = modelMapper.map(relationDTO, CreateRelationRequest.class);
                        if(!createRelationRequest.getRelativeMasterId().equals("")) {
                            createRelationRequest.setPositionId(detId);
                            createRelationRequest.setCmsId(cmsId);
                            final Relation relation = Relation.create(createRelationRequest);
                            this.relationRepository.save(relation);
                        }
                    }

                    for (RelationAliasesDTO relationAliasesDTO : dto.getRelationAliasesDTOS()) {
                        CreateRelationAliasesRequest createRelationAliasesRequest = modelMapper.map(relationAliasesDTO, CreateRelationAliasesRequest.class);
                        if(!createRelationAliasesRequest.getRelationAliasesName().isEmpty()) {
                            createRelationAliasesRequest.setPositionId(detId);
                            createRelationAliasesRequest.setCmsId(cmsId);
                            final RelationAliases relationAliases = RelationAliases.create(createRelationAliasesRequest);
                            this.relationAliasesRepository.save(relationAliases);
                        }
                    }

                    for (DetailsAboutRelationDTO detailsAboutRelationDTO : dto.getDetailsAboutRelationDTOS()) {
                        CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest = modelMapper.map(detailsAboutRelationDTO, CreateDetailsAboutRelationRequest.class);
                        if(!createDetailsAboutRelationRequest.getDetailsAboutRelation().isEmpty()) {
                            createDetailsAboutRelationRequest.setPositionId(detId);
                            createDetailsAboutRelationRequest.setCmsId(cmsId);
                            final DetailsAboutRelation detailsAboutRelation = DetailsAboutRelation.create(createDetailsAboutRelationRequest);
                            this.detailsAboutRelationRepository.save(detailsAboutRelation);
                        }
                    }
                //}
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }

    @Override
    public Response createAndUpdateIndOrgDetails(Integer cmsId, Integer euid, List<IndOrgCommonDTO> indOrgCommonDTOS) {
        try {
            Response response = null;
            ModelMapper modelMapper = new ModelMapper();
            this.positionsWritePlatformService.DeActiveIndOrg(cmsId  , euid);
            for (IndOrgCommonDTO dto : indOrgCommonDTOS) {
                CreatePositionsRequest request = modelMapper.map(dto.getPositionsDTO(), CreatePositionsRequest.class);
                final Positions positions = Positions.create(request);
//                if (!positions.getLinIndName().isEmpty()) {
                String linIndName = positions.getLinIndName();
               // if (linIndName != null && !linIndName.isEmpty()) {
                    positions.setCmsId(cmsId);
                    this.positionsRepository.save(positions);
                    int detId = positions.getId();
                    response = Response.of(positions.getId());

                    for (IndAliasesNameDTO indAliasesNameDTO : dto.getIndAliasesNameDTOS()) {
                        CreateIndAliasesNameRequest createIndAliasesNameRequest = modelMapper.map(indAliasesNameDTO, CreateIndAliasesNameRequest.class);
                        if (!createIndAliasesNameRequest.getLinIndAliasesName().isEmpty()) {
                            createIndAliasesNameRequest.setPositionId(detId);
                            createIndAliasesNameRequest.setCmsId(cmsId);
                            final IndAliasesName indAliasesName = IndAliasesName.create(createIndAliasesNameRequest);
                            this.indAliasesNameRepository.save(indAliasesName);
                        }
                    }
                    for (RelationDTO relationDTO : dto.getRelationDTOS()) {
                        CreateRelationRequest createRelationRequest = modelMapper.map(relationDTO, CreateRelationRequest.class);

                        if (createRelationRequest.getRelativeMasterId()!=null && !createRelationRequest.getRelativeMasterId().equals("")) {
                            createRelationRequest.setPositionId(detId);
                            createRelationRequest.setCmsId(cmsId);
                            final Relation relation = Relation.create(createRelationRequest);
                            this.relationRepository.save(relation);
                        }
                    }

                    for (RelationAliasesDTO relationAliasesDTO : dto.getRelationAliasesDTOS()) {
                        CreateRelationAliasesRequest createRelationAliasesRequest = modelMapper.map(relationAliasesDTO, CreateRelationAliasesRequest.class);
                        if (!createRelationAliasesRequest.getRelationAliasesName().isEmpty()) {
                            createRelationAliasesRequest.setPositionId(detId);
                            createRelationAliasesRequest.setCmsId(cmsId);
                            final RelationAliases relationAliases = RelationAliases.create(createRelationAliasesRequest);
                            this.relationAliasesRepository.save(relationAliases);
                        }
                    }

                    for (DetailsAboutRelationDTO detailsAboutRelationDTO : dto.getDetailsAboutRelationDTOS()) {
                        CreateDetailsAboutRelationRequest createDetailsAboutRelationRequest = modelMapper.map(detailsAboutRelationDTO, CreateDetailsAboutRelationRequest.class);
                        if(!createDetailsAboutRelationRequest.getDetailsAboutRelation().isEmpty()) {
                            createDetailsAboutRelationRequest.setPositionId(detId);
                            createDetailsAboutRelationRequest.setCmsId(cmsId);
                            final DetailsAboutRelation detailsAboutRelation = DetailsAboutRelation.create(createDetailsAboutRelationRequest);
                            this.detailsAboutRelationRepository.save(detailsAboutRelation);
                        }
                    }
                //}
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_CMS_ApplicationException(e.getMessage());
        }
    }
}
