package ftn.isa.booking.response;

import java.util.List;

import ftn.isa.booking.model.Hotel;

public class HotelResponse {

private List<Hotel>ht;
	

	
	public HotelResponse(List<Hotel>hotels){
		
		this.ht=hotels;
	}



	public List<Hotel> getHt() {
		return ht;
	}



	public void setHt(List<Hotel> ht) {
		this.ht = ht;
	}
}
