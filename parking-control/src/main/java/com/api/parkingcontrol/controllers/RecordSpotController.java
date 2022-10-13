package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.beans.RecordSpot;
import com.api.parkingcontrol.services.ParkingSpotRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
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


    @PostMapping("/save")
    public ResponseEntity<Object> saveParkingSpot(@Valid @RequestBody RecordSpot parkingRequest) {


        parkingRequest.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));

        RecordSpot event = parkingSpotRecordService.saveEvent(parkingRequest);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(event);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Alguns dados estão incorretos: " + ex.getMessage());
        }


    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
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