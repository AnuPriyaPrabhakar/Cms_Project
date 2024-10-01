package com.ponsun.cms.SearchDetails.SearchDetails.domain;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.SearchDetails.SearchDetails.request.CreateSearchDetailsRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_search_details")
public class SearchDetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "searchId")
    private Integer searchId;

    @Column(name = "cmsId")
    private Integer cmsId;

    @Column(name = "name")
    private String name;

    @Column(name = "searchingScore")
    private double searchingScore;

    @Column(name = "typeId")
    private Integer typeId;

    @Column(name = "uid")
    private Integer uid;

    public static SearchDetails create(final CreateSearchDetailsRequest createSearchDetailsRequest) {
        final SearchDetails SearchDetails = new SearchDetails();
        SearchDetails.setSearchId(createSearchDetailsRequest.getSearchId());
        SearchDetails.setCmsId(createSearchDetailsRequest.getCmsId());
        SearchDetails.setName(createSearchDetailsRequest.getName());
        SearchDetails.setSearchingScore(createSearchDetailsRequest.getSearchingScore());
        SearchDetails.setTypeId(createSearchDetailsRequest.getTypeId());
        SearchDetails.setUid(createSearchDetailsRequest.getUid());
        SearchDetails.onCreate();
        SearchDetails.setStatus(Status.ACTIVE);
        return SearchDetails;
    }
}
