package ftn.isa.booking.model;


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Flights")
public class Flight implements Serializable  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, optional =true)
	@JsonIgnore
	private Airline airline;
	
	@OneToMany(mappedBy="flight", fetch = FetchType.EAGER)
	private Set<FlightStops> flightStops = new HashSet<FlightStops>();
	
	@Column(name="seatNumber")
	private Integer seatNumber;
	
	@OneToMany(mappedBy="flight", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Seat> seats = new HashSet<Seat>();
	/*
	@OneToMany(mappedBy="flight", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Ticket> ticket = new HashSet<Ticket>();
	*/
	
	@OneToOne(fetch = FetchType.EAGER)
	private Destination fromDest;
	
	@OneToOne( fetch = FetchType.EAGER)
	private Destination toDest;
	
	@Column(name = "NumberOfStops")
	private Integer stops;

	@Column(name = "TakeOffDateAndTime")
	private Date takeOff;
	
	@Column(name = "LandingDateAndTime")
	private Date landing;

	@Column(name="Duration")
	private double duration;

	@Column(name="Length")
	private double length;

	@Column(name="TicketPrice")
	private double ticketPrice;
	
	public Flight() {
		
	}

	

	public Flight(Airline airline, Set<Seat> seats, Date takeOff, Date landing, double duration, double length, double ticketPrice) {
		super();
		this.airline = airline;
		this.seats = seats;
		this.takeOff = takeOff;
		this.landing = landing;
		this.duration = duration;
		this.length = length;
		this.ticketPrice = ticketPrice;
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}


	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double price) {
		this.ticketPrice = price;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}


	public Destination getFromDest() {
		return fromDest;
	}


	public void setFromDest(Destination fromDest) {
		this.fromDest = fromDest;
	}


	public Destination getToDest() {
		return toDest;
	}


	public void setToDest(Destination toDest) {
		this.toDest = toDest;
	}


	public Integer getStops() {
		return stops;
	}


	public void setStops(Integer stops) {
		this.stops = stops;
	}



	public Set<FlightStops> getFlightStops() {
		return flightStops;
	}



	public void setFlightStops(Set<FlightStops> flightStops) {
		this.flightStops = flightStops;
	}



	public Integer getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(Integer seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	
	


}