package ftn.isa.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotels")
public class Hotel {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    private String name;
	    private String address;
	    private String description;
	    private Long average;
	    //private Map<String, String> services;
	   // private Map<Long, Long> roomArrangement;
	    private String admin;
	   
	    
	    public Hotel() {
			super();
		}
	    
	    
		/*public Map<Long, Long> getRoomArrangement() {
			return roomArrangement;
		}


		public void setRoomArrangement(Map<Long, Long> roomArrangement) {
			this.roomArrangement = roomArrangement;
		}*/

	    
	    
	    

		public Long getAverage() {
			return average;
		}

	
		public void setAverage(Long average) {
			this.average = average;
		}

		/*public Map<String, String> getServices() {
			return services;
		}

		public void setServices(Map<String, String> services) {
			this.services = services;
		}*/

		public String getAdmin() {
			return admin;
		}

		public void setAdmin(String admin) {
			this.admin = admin;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
