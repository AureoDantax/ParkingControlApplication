package com.api.parkingcontrol.repositories;


import com.api.parkingcontrol.beans.ParkingSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, Integer> {



}
