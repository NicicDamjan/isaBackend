package ftn.isa.booking.response;

import java.util.List;

import ftn.isa.booking.model.User;

public class UserResponse {

private List<User>users;
	
	
	
	public UserResponse(List<User>users){
		
		this.users=users;
	}



	public List<User> getUsers() {
		return users;
	}



	public void setCin(List<User> users) {
		this.users = users;
	}
}