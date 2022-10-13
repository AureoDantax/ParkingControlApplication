package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.RecordSpot;
import com.api.parkingcontrol.repositories.RecordSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotRecordService {


    @Autowired
    private RecordSpotRepository recordSpotRepository;


    public RecordSpot saveEvent(RecordSpot request) {
        RecordSpot recordSpot =
                RecordSpot.builder()
                        .vehicle(request.getVehicle())
                        .parkingSpot(request.getParkingSpot())
                        .event(request.getEvent())
                        .build();

        recordSpot = recordSpotRepository.save(recordSpot);

        return recordSpot;
    }

    public Boolean existsByParkingSpotNumber(RecordSpot parkingSpotNumber) {
        return recordSpotRepository.existsById(parkingSpotNumber.getParkingSpot().getId());
    }

}







