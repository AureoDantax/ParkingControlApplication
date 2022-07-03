package com.api.parkingcontrol.beans;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Table(name = "PARKING_SPOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpot {


    @Id
    @PrimaryKeyJoinColumn(referencedColumnName = "CPF")

    @NotBlank
    @Column(nullable = false, unique = true, length = 70)
    private String localization;

    public void setRegistrationDate(LocalDateTime utc) {
    }
}
