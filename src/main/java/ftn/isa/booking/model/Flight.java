package ftn.isa.booking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "flight")

public class Flight {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @NotNull
	    private String flightTime;
	    private String landingTime;
	    private String timeOfTravel;
	    private String lengthOfTravel;
	    private String numberOfTransfers;
	    private String ticketPrice;
	    
	    
		public Flight() {
			super();
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		
		
		public String getFlightTime() {
			return flightTime;
		}
		public void setFlightTime(String flightTime) {
			this.flightTime = flightTime;
		}
		public String getLandingTime() {
			return landingTime;
		}
		public void setLandingTime(String landingTime) {
			this.landingTime = landingTime;
		}
		public String getTimeOfTravel() {
			return timeOfTravel;
		}
		public void setTimeOfTravel(String timeOfTravel) {
			this.timeOfTravel = timeOfTravel;
		}
		public String getLengthOfTravel() {
			return lengthOfTravel;
		}
		public void setLengthOfTravel(String lengthOfTravel) {
			this.lengthOfTravel = lengthOfTravel;
		}
		public String getNumberOfTransfers() {
			return numberOfTransfers;
		}
		public void setNumberOfTransfers(String numberOfTransfers) {
			this.numberOfTransfers = numberOfTransfers;
		}
		public String getTicketPrice() {
			return ticketPrice;
		}
		public void setTicketPrice(String ticketPrice) {
			this.ticketPrice = ticketPrice;
		}
	    
	    
	    
	    
	    
	    
}
