package ftn.isa.booking.controller.airCompanyController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.airCompanyController.dto.RegistrationACDTO;
import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.model.AirCompany;
import ftn.isa.booking.services.AirCompanyService;

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
}
