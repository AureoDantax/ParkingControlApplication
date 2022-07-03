package com.api.parkingcontrol.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "PERSON")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(table = "CAR", referencedColumnName = "licensePlateCar")
    private Car car;

    @PrimaryKeyJoinColumn
    @NotBlank(message = "Por favor, insira o CPF")
    @Column(nullable = false, unique = true, length = 14)
    @org.hibernate.validator.constraints.br.CPF
    private String CPF;

    @NotBlank(message = "Por favor, insira o nome do proprietário do veiculo")
    @Column(nullable = false, unique = true, length = 130)
    private String Name;

    @NotBlank(message = "Por favor, insira o apartamento")
    @Column(nullable = false, unique = true, length = 30)
    private String Apartment;

    @NotBlank(message = "Por favor, insira o bloco")
    @Column(nullable = false, unique = true, length = 30)
    private String Block;

    @Email
    @NotBlank(message = "Por favor, insira o E-mail")
    @Column(nullable = false, unique = true, length = 200)
    private String Email;
}
