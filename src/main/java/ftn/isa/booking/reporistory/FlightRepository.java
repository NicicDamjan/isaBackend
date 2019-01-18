package ftn.isa.booking.reporistory;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	//@Query("from Flights  where f.airline_id=:id")
	ArrayList<Flight> findByAirlineId(@Param("id") Long id);

	ArrayList<Flight> findAllByAirline(Airline airline);

}
