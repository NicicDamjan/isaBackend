package ftn.isa.booking.controller.airCompanyController;


import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.airCompanyController.dto.FlightReservationDTO;
import ftn.isa.booking.controller.airCompanyController.dto.SearchFlightParamDTO;
import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightReservation;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.services.FlightReservationService;
import ftn.isa.booking.services.FlightService;
import ftn.isa.booking.services.SeatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/api")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private FlightReservationService flightReservationService;
	
	
	@Autowired
	private SeatService seatService;
	
	@RequestMapping(value = "//airlines/{id}/flights/{id}/addSeat",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a seat.", notes = "Returns the seat being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Seat addSeat(@ApiParam(value = "The seat object", required = true)  @PathVariable Long id){
		
		Flight flight = flightService.findById(id);
		
		Seat seat = new Seat();

		seat.setFlight(flight);
		
		seatService.save(seat);
		
		return seat;
		
	   
	}
	
	
	@RequestMapping(value = "/airlines/{id}/flights/{id1}/removeSeat/{id2}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a seat.", notes = "You have to provide a valid seat ID in the URL", httpMethod = "DELETE")
	public Flight deleteSeat(@ApiParam(value = "The ID of the existing seat.", required = true) @PathVariable Long id1, @PathVariable Long id2) {
		
		Seat seat = seatService.findById(id2);
		
		Flight flight = seat.getFlight();
		
		if(!seat.isReserved()) {
		
	    seatService.deleteById(id2);
	    return flight;
	    
		} else {
			return null;
		}
	}
	

	
	@RequestMapping(value = "/airlines/{id}/flights/{id}/getFlight", method = RequestMethod.GET)
	public Flight getFlight(@PathVariable Long id) {
		
		return flightService.findById(id);
		
		
	}
	
	@RequestMapping(value = "/airlines/{id}/flights/{id}/getSeats", method = RequestMethod.GET)
	public ArrayList<Seat> getSeats(@PathVariable Long id) {
		
		return flightService.findAllSeats(id);
		
		
	}
	
	@RequestMapping(value = "/flights/{id}/addSeats", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addSeats(@PathVariable Long id, @RequestBody Integer numberOfSeats) {
		
		flightService.addSeats(id, numberOfSeats);
		
		
	}
	
	@RequestMapping(value="/airlines/getFlightsByParams", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Flight> gettFlightsByParams(@RequestBody SearchFlightParamDTO sfp) throws ParseException{
		
		return flightService.searchFlightsByParam(sfp);
		
	}
	
	@RequestMapping(value="/reserveFlight", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Long reserveFlight(@RequestBody FlightReservationDTO fd) {
		
		return flightReservationService.reserveFlight(fd).getId();
		
	}
	@RequestMapping(value="/flight-reservations/{id}/cost", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public double getFlightReservationCost(@PathVariable Long id){
		FlightReservation fr = flightReservationService.findById(id);
		return  fr.getPrice();
	}

	
}