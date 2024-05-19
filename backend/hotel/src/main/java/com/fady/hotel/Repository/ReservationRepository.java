package com.fady.hotel.Repository;

import com.fady.hotel.Entity.Reservation;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    public Reservation findByReservationId(Long reservationId);

    @Query("SELECT r FROM Reservation r WHERE r.room.id = ?1")
    public List<Reservation> findByRoom(String id);

    public List<Reservation> findByUserId(Long userId);

    public List<Reservation> findByReservationStatus(String reservationStatus);

    public List<Reservation> findByReservationType(String reservationType);

    public List<Reservation> findByReservationPrice(float reservationPrice);

    public List<Reservation> findByReservationPaymentMethod(String reservationPaymentMethod);

    public List<Reservation> findByReservationPaymentStatus(String reservationPaymentStatus);

    @Query("SELECT r FROM Reservation r WHERE r.reservationPaymentDate = ?1")
    public List<Reservation> findByReservationPaymentDate(Date reservationPaymentDate);

    @Query("SELECT r FROM Reservation r WHERE r.reservationDate = ?1")
    public List<Reservation> findByReservationDate(Date reservationDate);

    @Query("SELECT r FROM Reservation r WHERE r.checkInDate = ?1")
    public List<Reservation> findByCheckInDate(Date checkInDate);

    @Query("SELECT r FROM Reservation r WHERE r.checkOutDate = ?1")
    public List<Reservation> findByCheckOutDate(Date checkOutDate);

}
