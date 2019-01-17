package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.isa.booking.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
