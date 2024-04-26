package com.fady.hotel.Service;

import java.util.List;

import com.fady.hotel.Entity.Reservation;
import com.fady.hotel.Repository.ReservationRepository;
import com.fady.hotel.Service.Interface.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation saveReservation(Reservation reservationRequest) {
        // Check if reservation exists
        Reservation reservationByReservationId = reservationRepository
                .findByReservationId(reservationRequest.getReservationId());
        if (reservationByReservationId != null) {
            throw new RuntimeException("Reservation already exists..!!");
        }
        return reservationRepository.save(reservationRequest);
    }

    @Override
    public Reservation getReservationById(Long reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    @Override
    public List<Reservation> getReservationByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        // Check if reservation exists
        Reservation reservationByReservationId = reservationRepository
                .findByReservationId(reservation.getReservationId());
        if (reservationByReservationId == null) {
            throw new RuntimeException("Reservation not found..!!");
        }
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

}
