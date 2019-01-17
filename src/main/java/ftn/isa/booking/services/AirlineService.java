package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Airline;
import ftn.isa.booking.reporistory.AirlineRepository;


@Service
public class AirlineService {
		
	@Autowired
	private AirlineRepository airlineRepository;
	
	 public void saveAirline(Airline airline) {
	    	airlineRepository.save(airline);
	    }
	 
	 public Airline getOne(Long id) {
	        return airlineRepository.findOneById(id);
	    }
	 
	 public void deleteById(Long id) {
	    	airlineRepository.deleteById(id);
	    }
	 
	 
	    
}
