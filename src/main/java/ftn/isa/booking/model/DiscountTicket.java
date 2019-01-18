package ftn.isa.booking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="DiscountTickets")
public class DiscountTicket implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	/*
	@Column(name="From")
	private Destination from;
	
	@Column(name="To")
	private Destination to;
	*/
	@ManyToOne
	@JsonIgnore
	private Airline airline;
	
//	@ManyToOne
//	private Flight flight;
	
	public DiscountTicket() {
		
	}

	public DiscountTicket(Long id, Destination from, Destination to, Airline airline/*, Flight flight*/) {
		super();
		this.id = id;
	//	this.from = from;
	//	this.to = to;
		this.airline = airline;
		//this.flight = flight;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
/*
	public Destination getFrom() {
		return from;
	}

	public void setFrom(Destination from) {
		this.from = from;
	}

	public Destination getTo() {
		return to;
	}

	public void setTo(Destination to) {
		this.to = to;
	}
*/
	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}
/*
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	*/
	
	
}
