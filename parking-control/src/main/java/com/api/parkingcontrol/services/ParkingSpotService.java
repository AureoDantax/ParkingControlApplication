package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

   @Autowired
    private ParkingSpotRepository parkingSpotRepository;




    public ParkingSpot createParkigSpot(ParkingSpot parkingSpotModel) {

        ParkingSpot parkingSpot = ParkingSpot.builder()
                .id(parkingSpotModel.getId())
                .localization(parkingSpotModel.getLocalization())
                .build();
            parkingSpot = parkingSpotRepository.save(parkingSpot);

        return parkingSpot;
    }



}







