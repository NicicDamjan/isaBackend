package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.FlightReservation;


@Repository
public interface FlightReservationRepository extends JpaRepository<FlightReservation, Long> {

	FlightReservation findOneById(Long id);
	
}
