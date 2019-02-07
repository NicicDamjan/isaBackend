package ftn.isa.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="FastFlightReservation")
public class FastFlightReservation {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Flight flight;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Seat seat;
	
	@Column(name="Price")
	private double price;
	
	@Column(name="Discount")
	private float discount;
	
	@Column(name="FinalPrice")
	private double finalPrice;
	
	@OneToOne
	private User user;

	public FastFlightReservation() {
		
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

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
