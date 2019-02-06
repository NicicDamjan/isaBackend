package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightReservation;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.model.User;
import ftn.isa.booking.reporistory.DestinationRepository;
import ftn.isa.booking.reporistory.FlightRepository;
import ftn.isa.booking.reporistory.FlightReservationRepository;
import ftn.isa.booking.reporistory.SeatRepository;
import ftn.isa.booking.reporistory.UsersRepository;

@Service
public class FlightReservationService {

	@Autowired
	private FlightReservationRepository flightResRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private SeatService seatService;
	
	
	
	
	
	public FlightReservation findById(Long id){
		return flightResRepository.findById(id).get();
	}
}
