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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "PARKING_SPOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingSpot {

    @Id
    private Integer id;

    @ManyToMany(mappedBy = "parkingSpot")
    private List<Person> owner = new ArrayList<>();

    @NotBlank
    @Column(nullable = false, unique = true, length = 70)
    private String localization;

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
