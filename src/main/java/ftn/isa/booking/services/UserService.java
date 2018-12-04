package ftn.isa.booking.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.User;
import ftn.isa.booking.reporistory.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public User regisrateUser(User user) {
    	
    	user.setRole("USER");
    	user.setActive(false);    
    	user.setConfirmationToken(UUID.randomUUID().toString());
    	user = usersRepository.save(user);
    	
    	return user;
    	
    	
    }
   
 
    public User getOne(Long id) {
        return usersRepository.findOneById(id);
    }
    
    public boolean checkUniqueEmail(String email) {
    	
    	if(usersRepository.findOneByEmail(email)!=null) {
    		return false;
    	}   	
    	return true;
    }
    
    

}