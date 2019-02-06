package ftn.isa.booking.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "FlightReservation")
public class FlightReservation implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=true)
	private Flight flight;

	@ManyToOne(fetch = FetchType.LAZY, optional =true)
    private User user;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<AirlineServices> services = new HashSet<AirlineServices>();
	
	@Column(name="ReservationPrice")
	private double price; 
	 
	public FlightReservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<AirlineServices> getServices() {
		return services;
	}

	public void setServices(Set<AirlineServices> services) {
		this.services = services;
	}
	 
	

}
