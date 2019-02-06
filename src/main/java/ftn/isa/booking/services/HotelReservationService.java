package ftn.isa.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ftn.isa.booking.model.HotelReservation;
import ftn.isa.booking.reporistory.HotelReservationRepository;

public class HotelReservationService {

	@Autowired
    private HotelReservationRepository hotelReservationRepository;
	
	
	 public HotelReservation findById(Long id){
	        return hotelReservationRepository.findById(id).get();
	    }

	    public List<HotelReservation> findAllHotelReservations(){
	        return  hotelReservationRepository.findAll();
	    }

	    public void saveReservation(HotelReservation hotelReservation){
	        hotelReservationRepository.save(hotelReservation);
	    }

	    public List<HotelReservation>  findReservationsForHotel(Long id){
	        List<HotelReservation> all = findAllHotelReservations();
	        List<HotelReservation> ret = new ArrayList<>();

	        for (HotelReservation res: all) {
	            if ((long)res.getHotel().getId() == (long)id){
	                ret.add(res);
	            }

	        }
	        return  ret;

	    }

}
