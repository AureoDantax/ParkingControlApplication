package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.beans.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import com.api.parkingcontrol.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking_spot")
public class CreateParkingSpotController {

    @Autowired
    private ParkingSpotService parkingSpotService;
    @Autowired
    private ParkingSpotRepository parkingSpotRepository;



    @PostMapping("/create")
    public ResponseEntity<Object> saveParkingSpot(@Valid @RequestBody ParkingSpot parkingSpotModel) {
            ParkingSpot createParkingSpot =  parkingSpotService.createParkigSpot(parkingSpotModel);

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotModel);
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