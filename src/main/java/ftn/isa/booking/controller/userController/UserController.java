package ftn.isa.booking.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.controller.userController.dto.RegistrationDTO;
import ftn.isa.booking.model.User;
import ftn.isa.booking.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {


	    @Autowired
	    private UserService userService;

	    @GetMapping("/{id}")
	    public User getUser(@PathVariable String id) {
	        return userService.getOne(Long.parseLong(id));
	    }
	    
	    
	    @PostMapping("/registration")
	    public MessageResponseDTO registration(@RequestBody RegistrationDTO registrationDTO) {
	    	
	    	User user = new User();
	    	
	    	if (!(userService.checkUniqueEmail(registrationDTO.getEmail()))) { //Proveravamo da li vec postoji email u bazi
				return new MessageResponseDTO("This email already exists");
			}
	    	user.setEmail(registrationDTO.getEmail());
	    	
	    	if(!(registrationDTO.getPassword1().equals(registrationDTO.getPassword2()))) {
	    	   return new MessageResponseDTO("Password1 and password2 is not equal!");
	    	}
	    	
	    	user.setCity(registrationDTO.getCity());
	    	user.setName(registrationDTO.getName());
	    	user.setSurname(registrationDTO.getSurname());
	    	user.setPassword(registrationDTO.getPassword1());
	    	user.setPhonenumber(registrationDTO.getPhonenumber());
	    	
	    	User temp = userService.regisrateUser(user);
	    	
	    	if(temp==null)
	    	return new MessageResponseDTO("User is not registrated");
	    	
	    	return new MessageResponseDTO("User is registrated");
	    }

	    
	}

