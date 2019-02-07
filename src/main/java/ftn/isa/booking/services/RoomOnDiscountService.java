package ftn.isa.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ftn.isa.booking.dto.HotelServiceDTO;
import ftn.isa.booking.model.HotelServices;
import ftn.isa.booking.model.RoomsOnDiscount;
import ftn.isa.booking.reporistory.RoomsOnDiscountRepository;

@Service
public class RoomOnDiscountService {

private RoomsOnDiscountRepository roomsOnDiscountRepository;
public List<RoomsOnDiscount> findAll(){
    return roomsOnDiscountRepository.findAll();
}

public  RoomsOnDiscount findById(Long id){
    return  roomsOnDiscountRepository.findById(id).get();
}

public List<HotelServiceDTO> findExtraServicesOfReservation(Long id){
    RoomsOnDiscount rooms = findById(id);
    List<HotelServiceDTO> ret = new ArrayList<>();
    for (HotelServices hs: rooms.getExtraServices()) {
        HotelServiceDTO hotelServiceDTO =new HotelServiceDTO(hs.getId(), hs.getName(), hs.getCost(), hs.getH().getId());
        ret.add(hotelServiceDTO);
    }
    return ret;

}
}
