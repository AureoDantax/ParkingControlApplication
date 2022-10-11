package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.ParkingSpot;
import com.api.parkingcontrol.beans.Person;
import com.api.parkingcontrol.repositories.SavePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {

    @Autowired
    SavePersonRepository savePersonRepository;


    public Person createPerson (Person personModel){
        Person person = Person.builder().
                cpf(personModel.getCpf()).
                name(personModel.getName()).
                email(personModel.getEmail()).
                parkingSpot(personModel.getParkingSpot()).
                vehicle(personModel.getVehicle()).
                apartment(personModel.getApartment()).
                block(personModel.getBlock())
                .build();
            person = savePersonRepository.save(person);
        return person;
    }

}