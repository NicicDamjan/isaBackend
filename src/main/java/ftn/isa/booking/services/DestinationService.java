package ftn.isa.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.Destination;
import ftn.isa.booking.reporistory.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	private DestinationRepository destinationRepository;

	public Destination findById(Long id) {
		return destinationRepository.findById((long) id).get();
	}
	
	public Destination findByName(String name) {
		return destinationRepository.findByName(name);
	}

	public Destination save(Destination destination) {
		return destinationRepository.save(destination);
	}
	
	
	//public List<Destination> findAll(Long id){
	//	return destinationRepository.findAllById(id);
	//}
	
}
