package ftn.isa.booking.controller.airCompanyController.dtoFlight;

public class RegistrationFLIGHTDTO {
	
		private String flightTime;
	    private String landingTime;
	    private String timeOfTravel;
	    private String lengthOfTravel;
	    private String numberOfTransfers;
	    private String ticketPrice;
	    
	    
		public RegistrationFLIGHTDTO () {
			super();
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
