package com.api.parkingcontrol.services;

import com.api.parkingcontrol.beans.ParkingSpot;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService {

   @Autowired
    private ParkingSpotRepository parkingSpotRepository;


    public ParkingSpot save(ParkingSpot parkingSpotModel) {
//        if (parkingSpotService.existsByLicensePlateCar(parkingSpot.getLicensePlateCar())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Esta placa já está em uso!");
//        }
//        if (parkingSpotService.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Esta vaga já está em uso!");
//        }
//        if (parkingSpotService.existsByapartmentAndBlock(parkingSpot.getApartment(), parkingSpot.getBlock())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Este apartamento e bloco já utiliza uma vaga!");
//        }

        return parkingSpotRepository.save(parkingSpotModel);
    }

    public Boolean existsByLicensePlateCar(String licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public Boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public Boolean existsByapartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
   }


}







