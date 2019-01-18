package ftn.isa.booking.reporistory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.Destination;
import ftn.isa.booking.model.Flight;


@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

	
	Destination findByName(String name);



}
