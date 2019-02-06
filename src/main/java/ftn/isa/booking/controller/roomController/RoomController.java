package ftn.isa.booking.controller.roomController;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.dto.RoomDTO;
import ftn.isa.booking.model.Room;
import ftn.isa.booking.services.RoomService;

@RestController
@RequestMapping(value = "/api")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/hotels/{hotelId}/rooms", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<RoomDTO> getRoomsOfHotel(@PathVariable Long hotelId){
        List<Room> rooms = roomService.findAllRooms();
        List<RoomDTO> ret = new ArrayList<>();

        System.out.println("Usao u funkciju za dobijanje soba hotela sa idom "+ hotelId);
        for (Room r: rooms) {

            if ((long)r.getHotel().getId() == (long)hotelId && r.isActive() == true){
                System.out.println(r.getHotel().getId());
                RoomDTO roomDTO = new RoomDTO(r.getId(),r.isReserved(),r.getCostPerNight(),r.getHotel().getId(),
                        r.getCapacity(),r.getFloor(),r.isHasBalcony(),r.getRoomType());
                roomDTO.setCostValidFrom(r.getCostValidFrom());
                roomDTO.setCostValidUntil(r.getCostValidUntil());
                roomDTO.setReservedFrom(r.getReservedFrom());
                roomDTO.setReservedUntil(r.getReservedUntil());

                ret.add(roomDTO);
             //  System.out.println("Nasao sobu!");
            }
        }
        System.out.println("Broj soba: "+ ret.size());
        return  ret;
    }

    @RequestMapping(value = "/rooms/{roomId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public RoomDTO getRoom(@PathVariable Long roomId){
             Room r = this.roomService.findRoom(roomId);
             if (r!=null && r.isActive() == true){
                 RoomDTO roomDTO = new RoomDTO(r.getId(),r.isReserved(),r.getCostPerNight(),r.getHotel().getId(),
                         r.getCapacity(),r.getFloor(),r.isHasBalcony(),r.getRoomType());
                 roomDTO.setCostValidFrom(r.getCostValidFrom());
                 roomDTO.setCostValidUntil(r.getCostValidUntil());
                 roomDTO.setReservedFrom(r.getReservedFrom());
                 roomDTO.setReservedUntil(r.getReservedUntil());
                 return roomDTO;
             }
        return  null;
    }
}



