package ftn.isa.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.FastHotelReservation;
import ftn.isa.booking.model.HotelReservation;
import ftn.isa.booking.reporistory.FastHotelReservationRepository;
import ftn.isa.booking.reporistory.HotelReservationRepository;

@Service
public class HotelReservationService {

	@Autowired
    private HotelReservationRepository hotelReservationRepository;
	
	 @Autowired
	 FastHotelReservationRepository fastHotelReservationRepository;
	
	
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
	    
	    public List<FastHotelReservation>  findFastReservationsForHotel(Long id){
	        List<FastHotelReservation> all =  fastHotelReservationRepository.findAll();
	        List<FastHotelReservation> ret = new ArrayList<>();

	        for (FastHotelReservation res: all) {
	            if ((long)res.getRoom().getHotel().getId() == (long)id){
	                ret.add(res);
	            }

	        }
	        return  ret;

	    }

	    public void createFastReservation(FastHotelReservation hotelReservation){
	        fastHotelReservationRepository.save(hotelReservation);
	    }

	    public void createReservation(HotelReservation hotelReservation){
	        hotelReservationRepository.save(hotelReservation);
	    }
	}
