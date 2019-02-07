package ftn.isa.booking.reporistory;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.Seat;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>  {
	ArrayList<Seat> findAllByFlight(Flight flight);
}
