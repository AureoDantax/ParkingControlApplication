package com.api.parkingcontrol.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "RECORD_SPOT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecordSpot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; //ahahahahhaha

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private ParkingSpot parkingSpot;

    @Enumerated(EnumType.STRING)
    private EventType event;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;

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
