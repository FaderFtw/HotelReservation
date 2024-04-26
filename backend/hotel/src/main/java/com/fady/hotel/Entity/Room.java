package com.fady.hotel.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue()
    private Long id;
    private String roomType;
    private String roomStatus;
    private double roomPrice;
    private String roomImage;
    private String roomCapacity;
    private String roomBedType;
    private String roomView;
    private String roomSize;
    private String roomFacilities;

}
