package ftn.isa.booking.controller.airCompanyController.dto;

import java.util.Date;

public class FlightStopsDTO {

	private Long id;
	private DestinationDTO dest;
	private Date dateStop;
	private Date dateTakeOff;
	
	public FlightStopsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public DestinationDTO getDest() {
		return dest;
	}

	public void setDest(DestinationDTO dest) {
		this.dest = dest;
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

	
	
}
