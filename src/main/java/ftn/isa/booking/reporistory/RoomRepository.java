package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
