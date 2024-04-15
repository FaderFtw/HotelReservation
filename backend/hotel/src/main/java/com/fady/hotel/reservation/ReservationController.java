package com.fady.hotel.reservation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/example") // Define the endpoint path
    public String forwardToExample() {
        return "forward:/build/index.html"; // Forward the request to the HTML file
    }

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

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<String> deleteReservation(@RequestBody Long reservationId) {
        try {
            reservationService.deleteReservation(reservationId);
            return ResponseEntity.ok("Reservation deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@RequestParam Long reservationId) {
        try {
            Reservation reservationResponse = reservationService.getReservationById(reservationId);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        try {
            List<Reservation> reservationResponse = reservationService.getAllReservations();
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationByUserId(@RequestParam Long userId) {
        try {
            List<Reservation> reservationResponse = reservationService.getReservationByUserId(userId);
            return ResponseEntity.ok(reservationResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
