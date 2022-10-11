package com.api.parkingcontrol.repositories;


import com.api.parkingcontrol.beans.RecordSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecordSpotRepository extends CrudRepository<RecordSpot, UUID> {
    boolean existsById(Integer id);
}
