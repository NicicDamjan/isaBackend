package ftn.isa.booking.controller.airCompanyController.dto;

import java.util.ArrayList;

public class RegistrationACDTO {

	 private String name;
	    private String adress;
	    private String description;
	    private ArrayList<String> destinationList = new ArrayList<>();
	    
	    
	      
		public RegistrationACDTO() {
			super();
		}
		
		
		public String getName() {
			return name;
		}
		
		
		public void setName(String name) {
			this.name = name;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public ArrayList<String> getDestinationList() {
			return destinationList;
		}
		public void setDestinationList(ArrayList<String> destinationList) {
			this.destinationList = destinationList;
		}	
}
