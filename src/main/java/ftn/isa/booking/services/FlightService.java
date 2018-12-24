package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Flight;
import ftn.isa.booking.reporistory.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository flightRepository;
	
	 public Flight getOne(Long id) {
	        return flightRepository.findOneById(id);
	    }
	 
	 public void saveFlight(Flight flight) {
	    	flightRepository.save(flight);
	    }
	 
	 public void deleteById(Long id) {
	    	flightRepository.deleteById(id);
	    }
	 
	 
	 
}
