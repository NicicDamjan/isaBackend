package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightReservation;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.model.SeatTicket;
import ftn.isa.booking.model.User;
import ftn.isa.booking.reporistory.DestinationRepository;
import ftn.isa.booking.reporistory.FlightRepository;
import ftn.isa.booking.reporistory.FlightReservationRepository;
import ftn.isa.booking.reporistory.SeatRepository;
import ftn.isa.booking.reporistory.UsersRepository;
import ftn.isa.booking.reporistory.SeatTicketRepository;
import ftn.isa.booking.controller.airCompanyController.dto.FlightReservationDTO;



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
	
	@Autowired
	private SeatTicketRepository seatTicketRepository;
	
	
	public FlightReservation reserveFlight(FlightReservationDTO fd) {

		FlightReservation fr = new FlightReservation();
		
		User u = userRepository.findOneByEmail(fd.getEmail());
		
		Flight f = flightRepository.findById(fd.getFlightId()).get();
		
		Seat s = seatService.changeTypeSeat(fd.getSeatId());
		
		fr.setUser(u);
		fr.setFlight(f);
		fr.setPrice(fd.getPrice());
		
		SeatTicket st = new SeatTicket();
		
		st.setSeat(s);
		st.setPassport(fd.getPassport());
		
		fr.getSeatTickets().add(seatTicketRepository.save(st));
		
		fr.setPrice(fd.getPrice());
		
		//fr.getSeats().add(s);
		
		return flightResRepository.save(fr);

	}
	public FlightReservation findById(Long id){
		return flightResRepository.findById(id).get();
	}
}
