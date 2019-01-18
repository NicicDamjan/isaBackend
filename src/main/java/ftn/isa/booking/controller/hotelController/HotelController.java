package ftn.isa.booking.controller.hotelController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;

import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.controller.hotelController.dto.RegistrationHDTO;
import ftn.isa.booking.controller.hotelController.dto.ServiceDTO;
import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.model.User;
import ftn.isa.booking.response.HotelResponse;
import ftn.isa.booking.services.HotelService;
import ftn.isa.booking.services.UserService;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class HotelController {
	
	 @Autowired
	 private HotelService hotelService;
	 
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping("/{id}")
	 public Hotel getHotel(@PathVariable String id) {
        return hotelService.getOne(Long.parseLong(id));
     }
	 
	 @JsonValue
	 @GetMapping("/getHotels")
	 public HotelResponse getHotels(){
			
			List<Hotel>listht=hotelService.getAllHotels();
			
			
			return new HotelResponse(listht);
			
		}
	 
	 
	 
	 
	 @PostMapping("/registrationHotel")
	 public MessageResponseDTO registration(@RequestBody RegistrationHDTO registrationHDTO) {

     Hotel hotel = new Hotel();
     
     hotel.setName(registrationHDTO.getName());
     hotel.setAddress(registrationHDTO.getAddress());
     hotel.setDesc(registrationHDTO.getDescription());
     hotel.setAdmin(registrationHDTO.getAdmin());
     hotelService.saveHotel(hotel);
	
	 return new MessageResponseDTO("Hotel is registrated");
	 }
	 
	 @PostMapping("/editHotel")
	 public MessageResponseDTO editHotel(@RequestBody RegistrationHDTO registrationHDTO) {

     Hotel hotel = new Hotel();
     
     hotel.setName(registrationHDTO.getName());
     hotel.setAddress(registrationHDTO.getAddress());
     hotel.setDesc(registrationHDTO.getDescription());
     
     hotelService.saveHotel(hotel);
	
	 return new MessageResponseDTO("Hotel is edited");
	 }
	 
	 @PostMapping("/addService/{id}")
	 public MessageResponseDTO addService(@PathVariable String id,@RequestBody ServiceDTO serviceDTO) {

     Hotel hotel = hotelService.getOne(Long.parseLong(id));
     
    // hotel.getServices().put(serviceDTO.getName(), serviceDTO.getPrice());

     hotelService.saveHotel(hotel);
	
	 return new MessageResponseDTO("Servis is created");
	 }
	 
	 @DeleteMapping("/deleteHotel/{id}")
	 public MessageResponseDTO deleteAirCompany(@PathVariable String id) {
		 
		 hotelService.deleteById(Long.parseLong(id));
		 
		 return new MessageResponseDTO("Success deleted Hotel");	
	 }
	    
}
