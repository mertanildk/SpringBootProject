package com.deke.testredisdbjpa.repositories;

import com.deke.testredisdbjpa.entity.Facility;
import com.deke.testredisdbjpa.repositories.base.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;



@Component
public interface FacilityRepository extends BaseRepository<Facility> {

    @Query("select f from Facility f where f.specifications = :spesification")
    Facility getBySpesification(String spesification);


}
