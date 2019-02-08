package ftn.isa.booking.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonValue;

import ftn.isa.booking.controller.dto.MessageResponseDTO;
import ftn.isa.booking.controller.userController.dto.RegistrationDTO;
import ftn.isa.booking.model.User;
import ftn.isa.booking.response.UserResponse;
import ftn.isa.booking.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class UserController {


	    @Autowired
	    private UserService userService;

	    @GetMapping("/getUser/{id}")
	    public User getUser(@PathVariable String id) {
	        return userService.getOne(Long.parseLong(id));
	    }
	    

	    @GetMapping("/deleteActiveUser")
	    public  MessageResponseDTO deleteActiveUser(){
	        System.out.println("usao");
	        UserService.activeUser = null;
	        return new MessageResponseDTO("There is no active users!");
	    }
		
		
		@PostMapping("/setActiveUser/{userId}")
	    public  MessageResponseDTO setActiveUser(@PathVariable Long userId){
	        User activeUser = userService.getOne(userId);
	        UserService.activeUser = activeUser;
	        return new MessageResponseDTO("User is now active!");
	    }

	    @GetMapping("/getActiveUser")
	    public User getActiveUser(){
	    	User activeUser = UserService.activeUser;
	        return activeUser;
	    }
	    
	    @PostMapping("/login")
	    public User login(@RequestBody RegistrationDTO registrationDTO) {
	    	
	    	User user = new User();
	    	user = userService.getOneByEmail(registrationDTO.getEmail());
	    	if(user==null)
	    		return null;
	    	if(user.getPassword().equals(registrationDTO.getPassword1()))
	    		{
	    		UserService.activeUser=user;
	    		return user;
	    		}
	    	else
	    		return null;
	      	
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
	    
	    @PostMapping("/addSysAdmin")
	    public MessageResponseDTO addSysAdmin(@RequestBody RegistrationDTO registrationDTO) {
	    	
	    	User user = new User();
	    	  
	    	user = userService.getOneByEmail(registrationDTO.getEmail());
	    	user.setRole("ADMIN");
	    	
	    	userService.saveUser(user);
	    	
	  
	    	
	    	return new MessageResponseDTO("User is ADMIN now.");
	    }
	    
	    @PostMapping("/returnUserRole")
	    public MessageResponseDTO returnUserRole(@RequestBody RegistrationDTO registrationDTO) {
	    	
	    	
	    	User user = new User();
	        user = userService.getOneByEmail(userService.activeUser.getEmail());
	       
	        if(!(registrationDTO.getPassword1().equals(registrationDTO.getPassword2()))) {
		    	   return new MessageResponseDTO("Password1 and password2 is not equal!");
		    	}
	        
	        user.setPassword(registrationDTO.getPassword1());
	        user.setRole("USER");
	        
	        userService.saveUser(user);
	        
	    	   return new MessageResponseDTO("Uspesno promenjena sifra admina!");
	    }
	    
	    @PostMapping("/confirmEmail")
	    public MessageResponseDTO confirmEmail(@RequestParam("token") String token) {
	    	System.out.println("Usaoo");
	    	User user = userService.findByConfirmationToken(token);
			
			if(user==null) {
				return new MessageResponseDTO("Oops! This token is invalid!");
			}
			user.setActive(true);
			userService.saveUser(user);
		return new MessageResponseDTO("User is activated");
	    }
	    
	    @PostMapping("/edituser")
	    public MessageResponseDTO editUser(@RequestBody RegistrationDTO registrationDTO) {
	        
	        User user = new User();
	        user = userService.getOneByEmail(registrationDTO.getEmail());
	        user.setName(registrationDTO.getName());
	        user.setSurname(registrationDTO.getSurname());
	        user.setCity(registrationDTO.getCity());
	        user.setPhonenumber(registrationDTO.getPhonenumber());
	       
	        if(!(registrationDTO.getPassword1().equals(registrationDTO.getPassword2()))) {
		    	   return new MessageResponseDTO("Password1 and password2 is not equal!");
		    	}
	        
	        user.setPassword(registrationDTO.getPassword1());
	        
	        userService.saveUser(user);
	        
	    	   return new MessageResponseDTO("Uspesno editovanje");
	    }
	    
	    @JsonValue
		@GetMapping("/getUsers")
		public UserResponse getUsers(){
			List<User>listUsers=userService.findAllUsers();
			return new UserResponse(listUsers);	
		}

}

