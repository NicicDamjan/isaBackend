package ftn.isa.booking.controller.airCompanyController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.airCompanyController.dto.AirlineConfigurationDTO;
import ftn.isa.booking.controller.airCompanyController.dto.AirlineDTO;
import ftn.isa.booking.controller.airCompanyController.dto.AirlineServicesDTO;
import ftn.isa.booking.controller.airCompanyController.dto.DestinationDTO;
import ftn.isa.booking.controller.airCompanyController.dto.FlightDTO;
import ftn.isa.booking.model.Airline;
import ftn.isa.booking.model.AirlineConfiguration;
import ftn.isa.booking.model.AirlineServices;
import ftn.isa.booking.model.Destination;
import ftn.isa.booking.model.Flight;
import ftn.isa.booking.model.FlightStops;
import ftn.isa.booking.model.Seat;
import ftn.isa.booking.services.AirlineService;
import ftn.isa.booking.services.DestinationService;
import ftn.isa.booking.services.FlightService;
import ftn.isa.booking.services.SeatService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value="/api/airlines")
public class AirlineController {

	@Autowired
    private AirlineService airlineService;
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private SeatService seatService;
	
	
	@Autowired 
	private DestinationService destinationService;

	@RequestMapping(value = "/{id}/addFlight",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a flight.", notes = "Returns the flight being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Flight addFlight(@ApiParam(value = "The flight object", required = true) @PathVariable Long id, @RequestBody FlightDTO flightDTO){
		
		Airline airline = airlineService.findById(id);
		
		Destination d1 = destinationService.findByName(flightDTO.getFromDest());
		Destination d2 = destinationService.findByName(flightDTO.getToDest());
		
		Flight flight = new Flight();
		
		flight.setDuration(flightDTO.getDuration());
		flight.setLength(flightDTO.getLength());
		flight.setLanding(flightDTO.getLanding());
		flight.setTakeOff(flightDTO.getTakeOff());
		flight.setFromDest(d1);
		flight.setToDest(d2);
		flight.setTicketPrice(flightDTO.getTicketPrice());
		flight.setAirline(airline);
		flight.setStops(flightDTO.getStops());
		flight.setSeatNumber(flightDTO.getSeatNumber());
		
	    Flight fs1 = flightService.save(flight);
	   

		for(int i=0; i<fs1.getStops(); i++) {
			FlightStops fs = new FlightStops();
			fs.setDateStop(flightDTO.getFlightStops().get(i).getDateStop());
			fs.setDateTakeOff(flightDTO.getFlightStops().get(i).getDateTakeOff());
			 
			fs.setDestStop(destinationService.findByName(flightDTO.getFlightStops().get(i).getDest().getName()));
			fs.setFlight(fs1);
			flightService.saveStops(fs);
		}
		
		for(int i=0; i<fs1.getSeatNumber(); i++) {
			Seat s = new Seat();
			s.setFlight(fs1);
			seatService.save(s);
		}
		
	    
		return flight;
	}
	
	@RequestMapping(value = "/{id}/updateAirline", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update an airline.", notes = "Returns the airline being updated.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Airline updateAirline(@ApiParam(value = "The airline object", required = true) @RequestBody Airline airlineChanged){
		
		Airline airline = airlineService.findById(airlineChanged.getId()); 
			
		airline.setName(airlineChanged.getName());
		airline.setAddress(airlineChanged.getAddress());
		airline.setDescription(airlineChanged.getDescription());
		
		airlineService.save(airline);
		return airline;	
	}
	
	  @RequestMapping(value = "/add", method = RequestMethod.POST,
	            consumes =MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Create a airline resource.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	    
	            
	           
	    public void registerAirline(@ApiParam(value = "The airline object", required = true) @RequestBody AirlineDTO airline){
	        Airline a = new Airline(airline.getName(), airline.getAddress(), airline.getDescription(), new HashSet<>(), new HashSet<>());
	        airlineService.save(a);

	    }
	
	
	
	
	
	@RequestMapping(value = "/removeFlight/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a flight.", notes = "You have to provide a valid flight ID in the URL", httpMethod = "DELETE")
	public void deleteFlight(@ApiParam(value = "The ID of the existing flight.", required = true) @PathVariable Long id) {
	    flightService.deleteById(id);
	}
	
	@RequestMapping(value = "/getAllAirlines", method = RequestMethod.GET)
	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}
	
	@RequestMapping(value = "/{id}/getAllFlights", method = RequestMethod.GET)
	public ArrayList<Flight> getFlights(@PathVariable Long id) {
		
		 return  flightService.findAllFlights(id);
		 
		
	}
	
	
	@RequestMapping(value = "/getAirline/{id}", method = RequestMethod.GET)
	public Airline getAirline(@PathVariable Long id) {
		
		Airline airline = airlineService.findById(id);
		
		return airline;
	}
	

	@RequestMapping(value = "/{id}/getAllDestinations", method = RequestMethod.GET)
	public Set<Destination> getDestinations(@PathVariable Long id) {
		
		return airlineService.findById(id).getDestinations();
		
		
	}
	
	@RequestMapping(value = "/{id}/getDestination", method = RequestMethod.GET)
	public Destination getDestination(@PathVariable Long id) {
		
		return destinationService.findById(id);
		
		
	}
	
	@RequestMapping(value = "/{id}/addDestination",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Create a flight.", notes = "Returns the destination being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Destination addDestination(@ApiParam(value = "The destination object", required = true) @PathVariable Long id, @RequestBody DestinationDTO destinationDTO){
		
		Destination dest = new Destination();
		
		dest.setName(destinationDTO.getName());
		dest.setCity(destinationDTO.getCity());
		dest.setState(destinationDTO.getState());
		dest.setNick(destinationDTO.getNick());
		
		Airline airline = airlineService.findById(id);
		
		dest.getAirlines().add(airline);
		
		return destinationService.save(dest);
		
		
	
	}
	
	@RequestMapping(value = "/{id}/updateDestination", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update a destination.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public Destination updateDestintion(@ApiParam(value = "The destination object", required = true)@PathVariable("id") Long id, @RequestBody DestinationDTO destinationDTO){
		
		Destination dest = destinationService.findById(id);
		
		System.out.println(dest.getId());
			
		dest.setName(destinationDTO.getName());
		dest.setCity(destinationDTO.getCity());
		dest.setState(destinationDTO.getState());
		dest.setNick(destinationDTO.getNick());
		
		 destinationService.save(dest);
		 
		 return dest;
	}
	
	@RequestMapping(value = "/{id}/addService",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public AirlineServices addAirlineService( @PathVariable Long id, @RequestBody AirlineServicesDTO asDTO){
		
		AirlineServices as = new AirlineServices();
		
		as.setName(asDTO.getName());
		as.setPrice(asDTO.getPrice());
		
		Airline airline = airlineService.findById(id);

		as.setAirline(airline);
		
		return airlineService.saveService(as);
		
	}
	
	@RequestMapping(value = "/{id}/getAllServices",	method = RequestMethod.GET)
	public List<AirlineServices> getServices(@PathVariable Long id){
		
		return airlineService.getAirlineServices(id);
		
	}
	
	@RequestMapping(value = "/{id}/getOneService",	method = RequestMethod.GET)
	public AirlineServices getService(@PathVariable Long id){
		
		return airlineService.getOneService(id);
		
	}
	
	@RequestMapping(value = "/{id}/updateService", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update a service.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
	public AirlineServices updateService(@PathVariable("id") Long id, @RequestBody AirlineServicesDTO asDTO){
		
		AirlineServices as = airlineService.getOneService(id);
		
		as.setName(asDTO.getName());
		as.setPrice(asDTO.getPrice());
		
		return airlineService.saveService(as);
		
	}
	
	@RequestMapping(value = "/{id}/deleteService", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a service.", httpMethod = "DELETE")
	public void deleteService(@ApiParam(value = "The ID of the existing flight.", required = true) @PathVariable Long id) {

			airlineService.removeService(id);
		
	}
	
	@RequestMapping(value = "/{id}/addConfiguration",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void addConfiguration( @PathVariable Long id, @RequestBody AirlineConfigurationDTO acDTO){
		
		AirlineConfiguration ac = new AirlineConfiguration();

		ac.setArange(acDTO.getArange());
		ac.setColumnsA(acDTO.getColumnsA());
		ac.setRowsA(acDTO.getRowsA());
		
		airlineService.saveConfiguration(id, ac);
		
	}
	/*
	@RequestMapping(value = "/{id}/getConfiguration")
	public AirlineConfiguration getConfiguration( @PathVariable Long id){
		
		return airlineService.findConfiguration(id);
		
	}
	*/
	@RequestMapping(value = "/{id}/getConfigurationByAirline")
	public AirlineConfiguration getConfigurationByAirline( @PathVariable Long id){
		
		return airlineService.findConfigurationByAirline(id);
		
	}
	
	
	@RequestMapping(value = "/{id}/editConfiguration",	method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public void editConfiguration( @PathVariable Long id, @RequestBody AirlineConfigurationDTO acDTO){
	
		airlineService.editConfiguration(id, acDTO);
		
	}
}
