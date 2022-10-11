package com.api.parkingcontrol.beans;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ParkingEventRequest {
    private String plate;
    private EventType eventType;
    private Integer parkingId;

   public void setRegistrationDate(LocalDateTime date){

   }
}
