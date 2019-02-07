package ftn.isa.booking.controller.airCompanyController.dto;

public class FlightReservationDTO {

	private Long seatId;
	private String email;
	private Long flightId;
	private Integer passport;
	private double price;
	
	public FlightReservationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Integer getPassport() {
		return passport;
	}

	public void setPassport(Integer passport) {
		this.passport = passport;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
