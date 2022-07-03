package com.api.parkingcontrol.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;


@Entity
@Table(name="CAR")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {



    @Id
    @NotBlank(message = "Por favor, insira a placa do carro")
    @Size(max = 7)
    @Column(nullable = false, unique = true,  length = 7)
    private String licensePlateCar;

    @NotBlank ( message = "Por favor, insira o modelo do carro")
    @Column(nullable = false, length = 70)
    private String brandCar;

    @NotBlank (message = "Por favor, insira o modelo do carro")
    @Column(nullable = false,  length = 70)
    private String modelCar;

    @NotBlank (message = "Por favor, insira a cor do carro")
    @Column(nullable = false,  length = 70)
    private String colorCar;



}
