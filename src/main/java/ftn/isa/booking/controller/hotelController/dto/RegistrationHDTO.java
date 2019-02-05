package ftn.isa.booking.controller.hotelController.dto;

public class RegistrationHDTO {

	    private String name;
	    private String address;
	    private String city;
	    private String country;
	    private String description;
	    private String admin;
		
	    
	    
	    
	    
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getAdmin() {
			return admin;
		}
		public void setAdmin(String admin) {
			this.admin = admin;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
}
