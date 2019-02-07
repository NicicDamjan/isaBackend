package ftn.isa.booking.controller.roomController;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.dto.RoomDTO;
import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.model.HotelReservation;
import ftn.isa.booking.model.Room;
import ftn.isa.booking.model.RoomsOnDiscount;
import ftn.isa.booking.reporistory.RoomsOnDiscountRepository;
import ftn.isa.booking.services.HotelReservationService;
import ftn.isa.booking.services.HotelService;
import ftn.isa.booking.services.RoomService;

@RestController
@RequestMapping(value = "/api")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private RoomsOnDiscountRepository roomsOnDiscountRepository;
    @Autowired
    private HotelReservationService hotelReservationService;

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
    
    
    @RequestMapping(value = "/{hotelId}/{from}/{until}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<RoomDTO> findFreeRooms(@PathVariable Long hotelId, @PathVariable String from, @PathVariable String until){
        Hotel hotel = hotelService.findById(hotelId);
        if(hotel == null)
            return  null;
        System.out.println(from + "     " + until);
        String europeanDatePattern =  "dd-MM-yyyy";
        DateTimeFormatter europeanDateFormatter = DateTimeFormatter.ofPattern(europeanDatePattern);
        LocalDate d1 = LocalDate.parse(from, europeanDateFormatter);
        LocalDate d2 = LocalDate.parse(until, europeanDateFormatter);

        LocalDate date = LocalDate.now();
        if(date.isAfter(d1) || date.isAfter(d2)){
            System.out.println("Datum nije validan");
            return null;
        }
        Set<Room> allRooms = hotel.getRooms();
        System.out.println("Broj soba u hotelu: "+ allRooms.size());
        List<HotelReservation> reservations = hotelReservationService.findReservationsForHotel(hotelId);
        System.out.println("Broj rezervacija u hotelu: "+ reservations.size());
        Set<Room> occupiedRooms = new HashSet<>();
        List<RoomDTO> ret = new ArrayList<>();

        List<RoomsOnDiscount> allOnDiscount = roomsOnDiscountRepository.findAll();
        List<Room> zaBrisanje = new ArrayList<>();
        for (RoomsOnDiscount roomsOnDiscount:allOnDiscount) {
            for (Room r: allRooms) {
                    if ((long)r.getId() == (long)roomsOnDiscount.getRoom().getId()){
                        zaBrisanje.add(r);
                    }
            }
        }

        allRooms.removeAll(zaBrisanje);



        for (HotelReservation res: reservations) {
            // nadjem sve zauzete sobe u tom periodu
            if(res.getCheckOutDate().isAfter(d1) && res.getCheckOutDate().isBefore(d2) ||
                    res.getCheckInDate().equals(d1) && res.getCheckOutDate().equals(d2) ||
                    res.getCheckInDate().isAfter(d1) && res.getCheckInDate().isBefore(d2) ||
                    res.getCheckOutDate().isAfter(d1) && res.getCheckOutDate().isBefore(d2) ||
                    res.getCheckInDate().equals(d1) || res.getCheckOutDate().equals(d2) ||
                    res.getCheckInDate().equals(d2) || res.getCheckOutDate().equals(d1)
            ){
                for (Room r: res.getRooms()) {

                    if(  (res.getCheckOutDate().isBefore(r.getCostValidUntil()) ||
                            res.getCheckOutDate().equals(r.getCostValidUntil())) &&
                            (res.getCheckInDate().isAfter(r.getCostValidFrom()) ||
                                    res.getCheckInDate().equals(r.getCostValidFrom())))
                                    occupiedRooms.add(r);
                }
            }
        }

        if(occupiedRooms.size() == 0){
            for (Room room: allRooms) {

                if(  (d2.isBefore(room.getCostValidUntil()) ||
                        d2.equals(room.getCostValidUntil())) &&
                        (d1.isAfter(room.getCostValidFrom()) ||
                                d1.equals(room.getCostValidFrom()))){

                    RoomDTO roomDTO = new RoomDTO(room.getId(), false, room.getCostPerNight(), room.getHotel().getId(),
                            room.getCapacity(), room.getFloor(), room.isHasBalcony(), room.getRoomType());
                    roomDTO.setCostValidFrom(room.getCostValidFrom());
                    roomDTO.setCostValidUntil(room.getCostValidUntil());

                    if(room.isActive() == true)
                        ret.add(roomDTO);

                }
            }
            return  ret;
        }

        for (Room room: allRooms) {
            for (Room room1: occupiedRooms) {
                if( (long)room.getId() != (long)room1.getId()  && room.isActive() == true){
                    System.out.println("Nasao sobu");
                    if(  (d2.isBefore(room.getCostValidUntil()) ||
                            d2.equals(room.getCostValidUntil())) &&
                            (d1.isAfter(room.getCostValidFrom()) ||
                                    d1.equals(room.getCostValidFrom()))){

                        RoomDTO roomDTO = new RoomDTO(room.getId(), false, room.getCostPerNight(), room.getHotel().getId(),
                                room.getCapacity(), room.getFloor(), room.isHasBalcony(), room.getRoomType());
                        roomDTO.setCostValidFrom(room.getCostValidFrom());
                        roomDTO.setCostValidUntil(room.getCostValidUntil());
                        ret.add(roomDTO);

                    }
                }
            }
        }

        System.out.println("Broj pronadjenih soba:" + ret.size());
        return ret;
    }
    
    
    
    
}



