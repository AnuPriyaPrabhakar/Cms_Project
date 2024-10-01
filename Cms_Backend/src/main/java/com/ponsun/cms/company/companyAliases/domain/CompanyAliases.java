package com.ponsun.cms.company.companyAliases.domain;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.company.companyAliases.request.UpdateCompanyAliasesRequest;
import com.ponsun.cms.company.companyAliases.request.CreateCompanyAliasesRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_company_aliases")
public class CompanyAliases extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "recordTypeId")
    private Integer recordTypeId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "companyId")
    private Integer companyId;

    @Column(name = "aliasesName")
    private String aliasesName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CompanyAliases create(final CreateCompanyAliasesRequest createCompanyAliasesRequest) {
        final CompanyAliases companyAliases = new CompanyAliases();
        //companyAliases.setId(createCompanyAliasesRequest.getId());
        companyAliases.setRecordTypeId(createCompanyAliasesRequest.getRecordTypeId());
        companyAliases.setCmsId(createCompanyAliasesRequest.getCmsId());
        companyAliases.setCompanyId(createCompanyAliasesRequest.getCompanyId());
        companyAliases.setAliasesName(createCompanyAliasesRequest.getAliasesName());
        companyAliases.setUid(createCompanyAliasesRequest.getUid());
        companyAliases.onCreate();
        companyAliases.setStatus(Status.ACTIVE);
        return companyAliases;
    }

    public void update(UpdateCompanyAliasesRequest updateCompanyAliasesRequest) {
        this.setRecordTypeId(updateCompanyAliasesRequest.getRecordTypeId());
        this.setCmsId(updateCompanyAliasesRequest.getCmsId());
        this.setCompanyId(updateCompanyAliasesRequest.getCompanyId());
        this.setAliasesName(updateCompanyAliasesRequest.getAliasesName());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCompanyAliasesRequest updateCompanyAliasesRequest) {
        this.setEuid(updateCompanyAliasesRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
