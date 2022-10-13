package com.api.parkingcontrol.controllers;

import com.api.parkingcontrol.beans.Person;
import com.api.parkingcontrol.services.PersonService;
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
@RequestMapping("/parking_spot")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/users/create")
    ResponseEntity<Object> createUser(@Valid @RequestBody Person person) {
        Person personModel = personService.createPerson(person);
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personModel);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Alguns dados estão incorretos: " + ex.getMessage());
        }

    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
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
