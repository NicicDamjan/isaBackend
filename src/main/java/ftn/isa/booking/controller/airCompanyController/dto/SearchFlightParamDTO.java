package ftn.isa.booking.controller.airCompanyController.dto;

import java.util.Date;

public class SearchFlightParamDTO {

	private String from;
	private String to;
	private String fromDate;
	private String toDate;
	private String typeTravel;
	private String personNumber;
	
	
	public SearchFlightParamDTO() {
		super();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getTypeTravel() {
		return typeTravel;
	}

	public void setTypeTravel(String typeTravel) {
		this.typeTravel = typeTravel;
	}

	public String getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(String personNumber) {
		this.personNumber = personNumber;
	}
	
	
	
}
