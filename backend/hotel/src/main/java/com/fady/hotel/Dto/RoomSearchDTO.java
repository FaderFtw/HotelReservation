package com.fady.hotel.Dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomSearchDTO {
    private String roomType;
    private String roomStatus;
    private double roomPrice;
    private String roomImage;
    private String roomCapacity;
    private String roomBedType;
    private String roomView;
    private String roomSize;
    private String roomFacilities;

    private Date holidayStart;
    private Date holidayEnd;
}
