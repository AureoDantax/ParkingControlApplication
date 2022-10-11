package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.EventType;
import com.api.parkingcontrol.beans.ParkingSpot;
import com.api.parkingcontrol.beans.RecordSpot;
import com.api.parkingcontrol.beans.Vehicle;
import com.api.parkingcontrol.repositories.RecordSpotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ParkingSpotRecordService {


    @Autowired
    private RecordSpotRepository recordSpotRepository;


    public RecordSpot saveEvent(Vehicle vehicle, ParkingSpot parkingSpotModel, EventType eventType) {
        RecordSpot recordSpot = RecordSpot.builder()
                .eventDate(new Date())
                .event(eventType)
                .parkingSpot(parkingSpotModel)
                .vehicle(vehicle)
                .build();

        recordSpot = recordSpotRepository.save(recordSpot);

        return recordSpot;
    }

    public Boolean existsByParkingSpotNumber(Integer parkingSpotNumber) {
        return recordSpotRepository.existsById(parkingSpotNumber);
    }

}







