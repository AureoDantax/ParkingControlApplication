package com.api.parkingcontrol.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "PERSON")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @NotBlank(message = "Por favor, insira o CPF")
    @Column(nullable = false, unique = true, length = 14)
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;

    @NotBlank(message = "Por favor, insira o nome do proprietário do veiculo")
    @Column(nullable = false, unique = true, length = 130)
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    private List<Vehicle> vehicle = new ArrayList<>();


    @Email
    @NotBlank(message = "Por favor, insira o E-mail")
    @Column(nullable = false, unique = true, length = 200)
    private String email;

    @NotBlank(message = "Por favor, insira o apartamento")
    @Column(nullable = false, unique = true, length = 30)
    private String apartment;

    @NotBlank(message = "Por favor, insira o bloco")
    @Column(nullable = false, unique = true, length = 30)
    private String block;

    @ManyToMany
    private List<ParkingSpot> parkingSpot = new ArrayList<>();
    @Column(name = "created_at", updatable = false)
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
