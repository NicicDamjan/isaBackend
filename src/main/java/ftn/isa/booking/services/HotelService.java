package ftn.isa.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.*;
import ftn.isa.booking.reporistory.*;

@Service
public class HotelService {

	@Autowired
    private HotelsRepository hotelsRepository;
	
	@Autowired
    private HotelsRepository hotelRepository;
	
    @Autowired
    private HotelServiceRepository hotelServiceRepository;

    @Autowired
	private HotelRatingRepository hotelRatingRepository;

    @Autowired
    private HotelReservationRepository hotelReservationRepository;
	

	public List<Hotel> getAllHotels() {

		return hotelsRepository.findAll();

	}
	
	 public Hotel getOne(Long id) {
	        return hotelsRepository.findOneById(id);
	    }
	 
	 public Hotel getOneByName(String name) {
	        return hotelsRepository.findOneByName(name);
	    }
	 public void saveHotel(Hotel hotel) {
		    hotelsRepository.save(hotel);
	    }

	 public void deleteById(Long id) {
		hotelsRepository.deleteById(id);
		}
	 
	 public Hotel findById(Long id){
	        return  hotelRepository.findById(id).get();
	    }
	    public List<Hotel> findAllHotels(){
	        return  hotelRepository.findAll();
	    }

	    public void editHotel(Hotel hotel){
	        if(hotelRepository.findById(hotel.getId()).isPresent()){
	            hotelRepository.save(hotel);
	        }
	    }
	    //**************************************************************************
	    public HotelServices getHotelService(Long id){
	        if (hotelServiceRepository.findById(id).isPresent())
	            return hotelServiceRepository.findById(id).get();
	        else
	            return  null;
	    }
	    public  List<HotelServices> getServicesOfHotel(Long id){
	        List<HotelServices> ret = new ArrayList<>();
	        List<HotelServices> all = hotelServiceRepository.findAll();
	        for (HotelServices hs:all) {
	            if (hs.getH().getId() == id){
	                ret.add(hs);
	            }
	        }
	        return  ret;
	    }

	    public HotelServices addService(HotelServices s){
	       return hotelServiceRepository.save(s);

	    }
	    public  void  deleteHotelService(Long id){
	        HotelServices hs = hotelServiceRepository.findById(id).get();
	        hotelServiceRepository.delete(hs);
	    }


	    //***********************************************************************
	    public void createReservation(HotelReservation hotelReservation){
	        hotelReservationRepository.save(hotelReservation);
	    }
	    public HotelRating rateHotel(HotelRating hotelRating, Long id){
	        if(hotelRepository.findById(id).isPresent())
	        {
	           // hotelRepository.findById(id).get().getAllRatings().add(hotelRating);
	            return hotelRatingRepository.save(hotelRating);
	        }

	        return  null;

	    }
}
