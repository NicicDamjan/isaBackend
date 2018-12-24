package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	Flight findOneById(Long id);
}
