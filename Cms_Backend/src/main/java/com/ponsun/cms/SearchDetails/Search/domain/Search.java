package com.ponsun.cms.SearchDetails.Search.domain;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import com.ponsun.cms.SearchDetails.Search.request.CreateSearchRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_search")
public class Search extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "matchingScore")
    private double matchingScore;


    public static Search create(final CreateSearchRequest createSearchRequest) {
        final Search Search = new Search();
        Search.setId(createSearchRequest.getId());
        Search.setName(createSearchRequest.getName());
        Search.setMatchingScore(createSearchRequest.getMatchingScore());
        Search.onCreate();
        Search.setStatus(Status.ACTIVE);
        return Search;
    }
}
