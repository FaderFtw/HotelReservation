package com.fady.hotel.room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room roomRequest) {
        // Check if room exists
        Optional<Room> roomById = roomRepository.findById(roomRequest.getId());
        if (roomById.isPresent()) {
            throw new RuntimeException("Room already exists..!!");
        }
        return roomRepository.save(roomRequest);
    };

    @Override
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    };

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    };

    @Override
    public Room updateRoom(Room room) {
        // Check if room exists
        Optional<Room> roomById = roomRepository.findById(room.getId());
        if (roomById.isPresent() == false) {
            throw new RuntimeException("Room not found..!!");
        }
        return roomRepository.save(room);
    };

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public List<Room> findAvailableRoomsForHoliday(RoomSearchDTO roomSearchDTO) {
        List<Room> availableRoomsInUserHoliday = roomRepository
                .findAvailableRoomsForHoliday(roomSearchDTO.getHolidayStart(), roomSearchDTO.getHolidayEnd());
        List<Room> availableRooms = new ArrayList<Room>() {
        };
        for (Room room : availableRoomsInUserHoliday) {
            // for each field of roomSearchDTO, check if it is not null and equal to the
            // corresponding field in room, if yes append it to availableRooms
            if (roomSearchDTO.getRoomType() != null) {
                if (!(roomSearchDTO.getRoomType().equals(room.getRoomType()))) {
                    continue;
                }
            }
            if (roomSearchDTO.getRoomCapacity() != null) {
                if (!(roomSearchDTO.getRoomCapacity().equals(room.getRoomCapacity()))) {
                    continue;
                }
            }
            if (Math.abs(roomSearchDTO.getRoomPrice() - room.getRoomPrice()) > 0.0001) {
                continue;
            }
            if (roomSearchDTO.getRoomBedType() != null) {
                if (!(roomSearchDTO.getRoomBedType().equals(room.getRoomBedType()))) {
                    continue;
                }
            }
            if (roomSearchDTO.getRoomView() != null) {
                if (!(roomSearchDTO.getRoomView().equals(room.getRoomView()))) {
                    continue;
                }
            }
            if (roomSearchDTO.getRoomSize() != null) {
                if (!(roomSearchDTO.getRoomSize().equals(room.getRoomSize()))) {
                    continue;
                }
            }
            if (roomSearchDTO.getRoomFacilities() != null) {
                if (!(roomSearchDTO.getRoomFacilities().equals(room.getRoomFacilities()))) {
                    continue;
                }
            }

            availableRooms.add(room);

        }
        return availableRooms;
    };
}
