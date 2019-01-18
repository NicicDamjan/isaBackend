package ftn.isa.booking.controller.airCompanyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.services.FlightService;
import ftn.isa.booking.services.SeatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/api/airlines/{id}/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private SeatService seatService;
	
	@RequestMapping(value = "/{id}/addSeat",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a seat.", notes = "Returns the seat being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Seat addSeat(@ApiParam(value = "The seat object", required = true)  @PathVariable Long id){
		
		Flight flight = flightService.findById(id);
		
		Seat seat = new Seat();

		seat.setFlight(flight);
		
		seatService.save(seat);
		
		return seat;
		
	   
	}
	
	
	@RequestMapping(value = "/{id1}/removeSeat/{id2}", method = RequestMethod.DELETE)
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
	

	
	@RequestMapping(value = "/{id}/getFlight", method = RequestMethod.GET)
	public Flight getFlight(@PathVariable Long id) {
		
		return flightService.findById(id);
		
		
	}
	
	
	
}
