package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.beans.ParkingSpot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends CrudRepository<ParkingSpot, UUID> {
    boolean existsByLicensePlateCar(String licencePlateCar);

    boolean existsByApartmentAndBlock(String apartment, String block);

    boolean existsByParkingSpotNumber(String ParkingSpotNumber);

}
