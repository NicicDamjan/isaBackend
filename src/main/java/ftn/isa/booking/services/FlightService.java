package ftn.isa.booking.services;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.controller.airCompanyController.dto.SearchFlightParamDTO;
import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.Destination;
import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightStops;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.reporistory.DestinationRepository;
import ftn.isa.booking.reporistory.FlightRepository;
import ftn.isa.booking.reporistory.FlightStopsRepository;
import ftn.isa.booking.reporistory.SeatRepository;


@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private DestinationRepository destinationRepository;
	
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

	public ArrayList<Seat> findAllSeats(Long id) {
		
		Flight flight = findById(id);
		
		ArrayList<Seat> seats = seatRepository.findAllByFlight(flight);

		Collections.sort(seats, new SortSeat());
		
		return seats;

	}
	
	public class SortSeat implements Comparator<Seat>
	{

		@Override
		public int compare(Seat o1, Seat o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getId() - o2.getId());
		}
	}

	public void addSeats(Long id, Integer numberOfSeats) {
	
		Flight f = findById(id);
		
		for(int i=0; i<numberOfSeats; i++) {
			Seat s = new Seat();
			s.setFlight(f);
			seatRepository.save(s);
		}
		
	}

	public ArrayList<Flight> searchFlightsByParam(SearchFlightParamDTO sfp) throws ParseException {
		
		ArrayList<Flight> flights = new ArrayList<Flight>();
		
		String from = sfp.getFrom();
		String to = sfp.getTo();
		String d1 = sfp.getToDate();
		String d2 = sfp.getFromDate();
		
		ArrayList<Flight> flightsPom = (ArrayList<Flight>) flightRepository.findAll();
		
		Destination dest1 = destinationRepository.findByState(from);
		Destination dest2 = destinationRepository.findByState(to);
		
		System.out.println(dest1.getState());
		System.out.println(dest2.getState());
		
		for (int i=0; i<flightsPom.size(); i++) {

			String[] k = flightsPom.get(i).getTakeOff().toString().split(" ");

			// System.out.println("POSLATI DATUM: " + d2);
			// System.out.println("LET DATUM: " + flightsPom.get(i).getTakeOff());
			// System.out.println(k[0]);
			
			if ( flightsPom.get(i).getFromDest().getState().equals(dest1.getState()) &&
					
			     flightsPom.get(i).getToDest().getState().equals(dest2.getState())  &&
			     
			     k[0].equals(d2) ) {
				
						flights.add(flightsPom.get(i));
										
			}
			
		}
		
		
		return flights;
		
	}

	
	
	
	
}
