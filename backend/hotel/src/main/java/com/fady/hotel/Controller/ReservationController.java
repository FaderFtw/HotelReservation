package com.fady.hotel.Controller;

import java.util.List;

import com.fady.hotel.Entity.Reservation;
import com.fady.hotel.Service.Interface.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation) {
        try {
            Reservation reservationResponse = reservationService.saveReservation(reservation);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        try {
            Reservation reservationResponse = reservationService.updateReservation(reservation);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReservation(@RequestBody Long reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        try {
            Reservation reservationResponse = reservationService.getReservationById(id);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping({"/", ""})
    public ResponseEntity<List<Reservation>> getAllReservations() {
        try {
            List<Reservation> reservationResponse = reservationService.getAllReservations();
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user/")
    public ResponseEntity<List<Reservation>> getReservationByUserId(@RequestParam Long userId) {
        try {
            List<Reservation> reservationResponse = reservationService.getReservationByUserId(userId);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
