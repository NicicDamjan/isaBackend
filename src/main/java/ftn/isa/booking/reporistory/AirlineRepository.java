package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
	
	Airline findOneById(Long id);
	Airline findOneByName(String name);

}
