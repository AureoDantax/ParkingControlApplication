package com.api.parkingcontrol.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name="Vechile")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @NotBlank(message = "Por favor, insira a placa do carro")
    @Column(length = 20)
    private String licensePlate;

    @NotBlank ( message = "Por favor, insira o modelo do carro")
    @Column(nullable = false, length = 70)
    private String brandVechile;

    @NotBlank (message = "Por favor, insira o modelo do carro")
    @Column(nullable = false,  length = 70)
    private String modelVechile;

    @NotBlank (message = "Por favor, insira a cor do carro")
    @Column(nullable = false,  length = 70)
    private String colorVechile;

    @Column(name = "created_at", updatable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @JsonIgnore
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @JsonIgnore
    private Date updatedAt;

}
