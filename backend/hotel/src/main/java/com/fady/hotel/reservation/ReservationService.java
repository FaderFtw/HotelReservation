package com.fady.hotel.reservation;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ReservationService {

    public Reservation saveReservation(Reservation reservationRequest);

    public Reservation getReservationById(Long reservationId);

    public List<Reservation> getReservationByUserId(Long userId);

    public Reservation updateReservation(Reservation reservation);

    public void deleteReservation(Long reservationId);

    public List<Reservation> getAllReservations();

}
