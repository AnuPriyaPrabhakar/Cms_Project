package com.ponsun.cms.countryHq.domain;


import com.ponsun.cms.common.entity.Status;
import com.ponsun.cms.countryHq.request.CreateCountryHqRequest;
import com.ponsun.cms.countryHq.request.UpdateCountryHqRequest;
import com.ponsun.cms.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "cms_config_country_hq")
public class CountryHq extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CountryHq create(final CreateCountryHqRequest createCountryHqRequest){
        final CountryHq CountryHq = new CountryHq();
        CountryHq.setName(createCountryHqRequest.getName());
        CountryHq.setUid(createCountryHqRequest.getUid());
        CountryHq.onCreate();
        CountryHq.setStatus(Status.ACTIVE);
        return CountryHq;
    }

    public void update(UpdateCountryHqRequest updateCountryHqRequest){
        this.setName(updateCountryHqRequest.getName());
        this.setEuid(updateCountryHqRequest.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

    public void deactive(UpdateCountryHqRequest updateCountryHqRequest){
        this.setEuid(updateCountryHqRequest.getEuid());
        this.setStatus(Status.DELETE);
        this.onUpdate();
    }
}
