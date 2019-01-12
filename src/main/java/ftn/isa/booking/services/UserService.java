package ftn.isa.booking.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.User;
import ftn.isa.booking.reporistory.UsersRepository;


@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;
    
    public static User activeUser;
    
    @Autowired
    private EmailService emailService;

    
    public User regisrateUser(User user) {
    	
    	user.setRole("USER");
    	user.setActive(false);    
    	user.setConfirmationToken(UUID.randomUUID().toString());
    	user = usersRepository.save(user);
    	
    	String appUrl = "http://localhost:4200/confirmEmail/";//request.getScheme() + "://" + request.getServerName();
		SimpleMailMessage registrationEmail=new SimpleMailMessage();
		registrationEmail.setTo(user.getEmail());
		registrationEmail.setSubject("Registration Confirmation");
		registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
		+appUrl+ user.getConfirmationToken());
		emailService.sendEmail(registrationEmail);
    	
    	return user;
    	
    	
    }
 
 
    public User getOne(Long id) {
        return usersRepository.findOneById(id);
    }
    
    public User getOneByEmail(String email) {
    	return usersRepository.findOneByEmail(email);
    }
    
    public User findByConfirmationToken(String token) {
        return usersRepository.findOneByConfirmationToken(token);
    }
    
    public void saveUser(User user) {
    	usersRepository.save(user);
    }
    
    public boolean checkUniqueEmail(String email) {
    	
    	if(usersRepository.findOneByEmail(email)!=null) {
    		return false;
    	}   	
    	return true;
    }
    
    public List<User> findAllUsers() {
		return usersRepository.findAll();
	}
    

}