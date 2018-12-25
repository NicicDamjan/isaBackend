package ftn.isa.booking.controller.hotelController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.controller.hotelController.dto.RegistrationDTO;
import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.services.HotelService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class HotelController {
	
	 @Autowired
	 private HotelService hotelService;
	 
	 @GetMapping("/{id}")
	 public Hotel getHotel(@PathVariable String id) {
        return hotelService.getOne(Long.parseLong(id));
     }
	 
	 
	 @PostMapping("/registration")
	 public MessageResponseDTO registration(@RequestBody RegistrationDTO registrationDTO) {

     Hotel hotel = new Hotel();
     
     hotel.setName(registrationDTO.getName());
     hotel.setAddress(registrationDTO.getAddress());
     hotel.setDescription(registrationDTO.getDescription());
     
     hotelService.saveHotel(hotel);
	
	 return new MessageResponseDTO("Hotel is registrated");
	 }
	 
	 @PostMapping("/editHotel")
	 public MessageResponseDTO editHotel(@RequestBody RegistrationDTO registrationDTO) {

     Hotel hotel = new Hotel();
     
     hotel.setName(registrationDTO.getName());
     hotel.setAddress(registrationDTO.getAddress());
     hotel.setDescription(registrationDTO.getDescription());
     
     hotelService.saveHotel(hotel);
	
	 return new MessageResponseDTO("Hotel is edited");
	 }
	 
	 @DeleteMapping("/deleteHotel/{id}")
	 public MessageResponseDTO deleteAirCompany(@PathVariable String id) {
		 
		 hotelService.deleteById(Long.parseLong(id));
		 
		 return new MessageResponseDTO("Success deleted Hotel");	
	 }
	    
}
