package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.beans.ParkingEventRequest;
import com.api.parkingcontrol.repositories.RecordSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking_spot")
public class RecordSpotController {

    @Autowired
    private ParkingSpotRecordService parkingSpotRecordService;
    @Autowired
    private RecordSpotRepository recordSpotRepository;


    @PostMapping("/save")
    public ResponseEntity<Object> saveParkingSpot(@Valid @RequestBody ParkingEventRequest parkingEventRequest) {
// tratar aqui o evento
       // P     event

        parkingEventRequest.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotRecordService);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Alguns dados estão incorretos: " + ex.getMessage());
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}