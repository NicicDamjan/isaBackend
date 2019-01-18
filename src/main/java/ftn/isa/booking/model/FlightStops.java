package ftn.isa.booking.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="FlightStops")
public class FlightStops {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="DateStop")
	private Date dateStop;
	
	@Column(name="DateTakingOff")
	private Date dateTakeOff;
	
	@OneToOne
	private Destination destStop;
	
	@ManyToOne
	@JsonIgnore
	private Flight flight;

	public FlightStops() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateStop() {
		return dateStop;
	}

	public void setDateStop(Date dateStop) {
		this.dateStop = dateStop;
	}

	public Date getDateTakeOff() {
		return dateTakeOff;
	}

	public void setDateTakeOff(Date dateTakeOff) {
		this.dateTakeOff = dateTakeOff;
	}


	public Destination getDestStop() {
		return destStop;
	}

	public void setDestStop(Destination destStop) {
		this.destStop = destStop;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	
	

}
