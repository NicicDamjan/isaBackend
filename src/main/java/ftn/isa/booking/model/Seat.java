package ftn.isa.booking.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Seats")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="Reserved")
	private boolean reserved;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Price")
	private Integer price;
	
	@ManyToOne(fetch = FetchType.EAGER, optional =true)
	@JsonIgnore
	private Flight flight;
	
	public Seat() {
		name="To be filled";
		reserved = false;
	}

	public Seat(Long id, boolean reserved) {
		super();
		this.id = id;
		this.reserved = reserved;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	
}
