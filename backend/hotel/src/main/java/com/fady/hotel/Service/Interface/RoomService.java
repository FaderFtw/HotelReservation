package com.fady.hotel.Service.Interface;

import com.fady.hotel.Dto.RoomSearchDTO;
import com.fady.hotel.Entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room saveRoom(Room roomRequest);

    Optional<Room> getRoomById(Long id);

    List<Room> getAllRooms();

    Room updateRoom(Room room);

    void deleteRoom(Long id);

    List<Room> findAvailableRoomsForHoliday(RoomSearchDTO roomSearchDTO);
}
