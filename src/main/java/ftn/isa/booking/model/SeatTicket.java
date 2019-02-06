package ftn.isa.booking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="SeatTickets")
public class SeatTicket {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Seat seat;
	
	@Column(name="Passport")
	private Integer passport;

	public SeatTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Integer getPassport() {
		return passport;
	}

	public void setPassport(Integer passport) {
		this.passport = passport;
	}
	
	
	
}
