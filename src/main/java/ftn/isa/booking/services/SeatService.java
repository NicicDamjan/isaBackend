package ftn.isa.booking.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Seat;
import ftn.isa.booking.reporistory.SeatRepository;



@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;
	
	public Seat save(Seat seat) {
		return seatRepository.save(seat);
	}

	public void deleteById(long id) {
		seatRepository.deleteById(id);
		
	}
	
	public Seat findById(Long id) {
		Optional<Seat> s = seatRepository.findById(id);
		
		return s.get();
	}
}
