package ftn.isa.booking.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightStops;
import ftn.isa.booking.reporistory.FlightRepository;
import ftn.isa.booking.reporistory.FlightStopsRepository;



@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private FlightStopsRepository flightStopsRepository;
	
	@Autowired
	private AirlineService airlineService;
	
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	public void deleteById(long id) {
		flightRepository.deleteById(id);
		
	}
	
	public Flight findById(Long id) {
		Optional<Flight> f = flightRepository.findById(id);
		
		return f.get();
	}

	public ArrayList<Flight> findAllFlights(Long id) {
		Airline airline = airlineService.findById(id);
		ArrayList<Flight> flights = flightRepository.findAllByAirline(airline);

		return flights;

	}
	

	public FlightStops saveStops(FlightStops fs) {
		return flightStopsRepository.save(fs);
	}
	
	
	
}

