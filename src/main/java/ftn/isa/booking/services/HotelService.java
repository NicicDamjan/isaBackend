package ftn.isa.booking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.reporistory.HotelsRepository;

@Service
public class HotelService {

	@Autowired
    private HotelsRepository hotelsRepository;
	

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
}
