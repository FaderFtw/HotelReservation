package com.fady.hotel.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fady.hotel.Entity.Room;
import org.springdoc.core.converters.models.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

      public Optional<Room> findById(Long roomId);

      Page<Room> findByRoomType(String roomType, Pageable pageable);

      public List<Room> findByRoomStatus(String roomStatus);

      public List<Room> findByRoomPrice(double roomPrice);

      public List<Room> findByRoomCapacity(String roomCapacity);

      public List<Room> findByRoomBedType(String roomBedType);

      public List<Room> findByRoomView(String roomView);

      public List<Room> findByRoomSize(String roomSize);

      public List<Room> findByRoomFacilities(String roomFacilities);

      @Query("SELECT r FROM Room r WHERE NOT EXISTS (" +
                  "SELECT 1 FROM Reservation res WHERE res.room = r " +
                  "AND res.checkOutDate > :holidayStart " +
                  "AND res.checkInDate < :holidayEnd)")
      List<Room> findAvailableRoomsForHoliday(@Param("holidayStart") Date holidayStart,
                  @Param("holidayEnd") Date holidayEnd);

}
