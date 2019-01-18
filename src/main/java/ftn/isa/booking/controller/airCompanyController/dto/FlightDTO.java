package ftn.isa.booking.controller.airCompanyController.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FlightDTO implements Serializable {

	private Long id;
	private Date takeOff;
	private Date landing;
	private double length;
	private double ticketPrice;
	private double duration;
	private String airlineName;
	private String fromDest;
	private String toDest;
	private Integer stops;
	private Integer seatNumber;
	private List<FlightStopsDTO> flightStops;
	
	
	public FlightDTO() {
		
	}

	

	public String getFromDest() {
		return fromDest;
	}



	public void setFromDest(String fromDest) {
		this.fromDest = fromDest;
	}



	public String getToDest() {
		return toDest;
	}



	public void setToDest(String toDest) {
		this.toDest = toDest;
	}
	
	


	public Integer getStops() {
		return stops;
	}



	public void setStops(Integer stops) {
		this.stops = stops;
	}



	public FlightDTO(Date takeOff, Date landing, double length, double ticketPrice, double duration,
			String airlineName, String fromDest, String toDest) {
		super();
		this.takeOff = takeOff;
		this.landing = landing;
		this.length = length;
		this.ticketPrice = ticketPrice;
		this.duration = duration;
		this.airlineName = airlineName;
		this.fromDest = fromDest;
		this.toDest = toDest;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getTakeOff() {
		return takeOff;
	}


	public void setTakeOff(Date takeOff) {
		this.takeOff = takeOff;
	}


	public Date getLanding() {
		return landing;
	}


	public void setLanding(Date landing) {
		this.landing = landing;
	}


	public Double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getTicketPrice() {
		return ticketPrice;
	}


	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public String getAirlineName() {
		return airlineName;
	}


	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}



	public Integer getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}



	public List<FlightStopsDTO> getFlightStops() {
		return flightStops;
	}



	public void setFlightStops(List<FlightStopsDTO> flightStops) {
		this.flightStops = flightStops;
	}


	
	

	
	
}
