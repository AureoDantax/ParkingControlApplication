package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.*;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.repositories.RecordSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

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







