package com.fady.hotel.Dto;

import java.util.Date;

import com.fady.hotel.Entity.Room;
import com.fady.hotel.Entity.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {
    private Date reservationDate;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private UserInfo user;
    private String reservationStatus;
    private String reservationType;
    private float reservationPrice;
    private String reservationPaymentMethod;
    private String reservationPaymentStatus;
    private Date reservationPaymentDate;

}
