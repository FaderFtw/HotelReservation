package com.fady.hotel.room;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/api/v1/rooms")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Room> saveRoom(@RequestBody Room room) {
        try {
            Room roomResponse = roomService.saveRoom(room);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        try {
            Room roomResponse = roomService.updateRoom(room);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@RequestBody Long id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok("Room deleted successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Room>> getRoomById(@RequestParam Long id) {
        try {
            Optional<Room> roomResponse = roomService.getRoomById(id);
            return ResponseEntity.ok(roomResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        try {
            List<Room> roomResponses = roomService.getAllRooms();
            return ResponseEntity.ok(roomResponses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/search")
    public ResponseEntity<List<Room>> findAvailableRoomsForHoliday(@RequestBody RoomSearchDTO roomSearchDTO) {
        try {
            List<Room> roomResponses = roomService.findAvailableRoomsForHoliday(roomSearchDTO);
            return ResponseEntity.ok(roomResponses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
