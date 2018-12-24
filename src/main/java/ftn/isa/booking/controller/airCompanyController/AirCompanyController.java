package ftn.isa.booking.controller.airCompanyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.airCompanyController.dto.RegistrationACDTO;
import ftn.isa.booking.controller.airCompanyController.dtoFlight.RegistrationFLIGHTDTO;
import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.model.AirCompany;
import ftn.isa.booking.model.Flight;
import ftn.isa.booking.services.AirCompanyService;
import ftn.isa.booking.services.FlightService;

@RestController
@RequestMapping("/airCompany")
//@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class AirCompanyController {
	
	@Autowired
    private AirCompanyService airCompanyService;
	
	 @GetMapping("/{id}")
	    public AirCompany getAirCompany(@PathVariable String id) {
	        return airCompanyService.getOne(Long.parseLong(id));
	    }
	 
	 
	 @PostMapping("/registration")
	    public MessageResponseDTO registration(@RequestBody RegistrationACDTO registrationACDTO) {
	    	
	    	AirCompany airCompany = new AirCompany();
	    	
	    	airCompany.setName(registrationACDTO.getName());
	    	airCompany.setDescription(registrationACDTO.getDescription());
	    	airCompany.setAdress(registrationACDTO.getAdress());
	    	
	    	airCompanyService.saveAirCompany(airCompany);
	    	
			return new MessageResponseDTO("Success registrated AC");	
	 }
	 
	 
	 @PostMapping("/editAC")
	    public MessageResponseDTO editAC(@RequestBody RegistrationACDTO registrationACDTO) {
	    	
	    	AirCompany airCompany = new AirCompany();
	    	
	    	airCompany.setName(registrationACDTO.getName());
	    	airCompany.setDescription(registrationACDTO.getDescription());
	    	airCompany.setAdress(registrationACDTO.getAdress());
	    	
	    	airCompanyService.saveAirCompany(airCompany);
	    	
			return new MessageResponseDTO("Success edited AC");	
	 }
	 
	 @DeleteMapping("/deleteAC/{id}")
	    public MessageResponseDTO deleteAirCompany(@PathVariable String id) {
		 
		 airCompanyService.deleteById(Long.parseLong(id));
		 
		 return new MessageResponseDTO("Success deleted AC");	
	 }
	 
	 
	 
	 //OVO JE ZA FLIGHT
	 @Autowired
	    private FlightService flightService;
	 
	 @GetMapping("/flight/{id}")
	    public Flight getFlight(@PathVariable String id) {
	        return flightService.getOne(Long.parseLong(id));
	    }
	 
	 @PostMapping("/flight/registration")
	    public MessageResponseDTO registration(@RequestBody RegistrationFLIGHTDTO registrationFLIGHTDTO) {
	    	
	    	Flight flight = new Flight();
	    	
	    	flight.setFlightTime(registrationFLIGHTDTO.getFlightTime());
	    	flight.setLandingTime(registrationFLIGHTDTO.getLandingTime());
	    	flight.setLengthOfTravel(registrationFLIGHTDTO.getLengthOfTravel());
	    	flight.setNumberOfTransfers(registrationFLIGHTDTO.getNumberOfTransfers());
	    	flight.setTicketPrice(registrationFLIGHTDTO.getTicketPrice());
	    	flight.setTimeOfTravel(registrationFLIGHTDTO.getTimeOfTravel());
	    	
	    	
	    	flightService.saveFlight(flight);
	    	
			return new MessageResponseDTO("Success registrated flight");	
	 }
	 
	 @PostMapping("/editFlight")
	 public MessageResponseDTO editFlight(@RequestBody RegistrationFLIGHTDTO registrationFLIGHTDTO) {
	    	
	    	Flight flight = new Flight();
	    	
	    	flight.setFlightTime(registrationFLIGHTDTO.getFlightTime());
	    	flight.setLandingTime(registrationFLIGHTDTO.getLandingTime());
	    	flight.setLengthOfTravel(registrationFLIGHTDTO.getLengthOfTravel());
	    	flight.setNumberOfTransfers(registrationFLIGHTDTO.getNumberOfTransfers());
	    	flight.setTicketPrice(registrationFLIGHTDTO.getTicketPrice());
	    	flight.setTimeOfTravel(registrationFLIGHTDTO.getTimeOfTravel());
	    	
	    	
	    	flightService.saveFlight(flight);
	    	
			return new MessageResponseDTO("Success registrated flight");
	 }
	 
	 @DeleteMapping("/deleteFlight/{id}")
	    public MessageResponseDTO deleteFlight(@PathVariable String id) {
		 
		 flightService.deleteById(Long.parseLong(id));
		 
		 return new MessageResponseDTO("Success deleted Flight");	
	 }
		 
}
