package ftn.isa.booking.controller.hotelAdminController;




import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.dto.HotelReservationDTO;
import ftn.isa.booking.model.FastHotelReservation;
import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.model.HotelReservation;
import ftn.isa.booking.model.HotelServices;
import ftn.isa.booking.model.Room;
import ftn.isa.booking.model.User;
import ftn.isa.booking.services.HotelReservationService;
import ftn.isa.booking.services.HotelService;
import ftn.isa.booking.services.RoomService;
import ftn.isa.booking.services.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/user")
public class UserReservationController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelReservationService hotelReservationService;


    @RequestMapping(value = "/hotel-reservations/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a service resource.", notes = "Returns the service being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public void reserveHotel(@RequestBody HotelReservationDTO reservationDTO){
        HotelReservation hotelReservation = new HotelReservation();
        Set<Room> rooms = new HashSet<>();
        if(reservationDTO == null){
            System.out.println("Rezervacija je null!");
            return;
        }
        for (Long i: reservationDTO.getRooms() ) {
            Room r = roomService.findRoom(i);
                    //roomService.findRoomForReservation(i);
            r.setReserved(true);
            roomService.saveRoom(r);
            rooms.add(r);
        }
        Hotel h = hotelService.findById(reservationDTO.getHotelId());
        User u = userService.getOneByEmail(userService.activeUser.getEmail()); //U username nam je email kkorisnika

        Set<HotelServices> services = new HashSet<>();
        for (Long i: reservationDTO.getExtraServices() ) {
            HotelServices hs = hotelService.getHotelService(i);
            if(hs!= null){
                services.add(hs);
            }
        }

        hotelReservation.setHotel(h);
        hotelReservation.setUser(u);
        hotelReservation.setRooms(rooms);
        hotelReservation.setCheckInDate(reservationDTO.getCheckInDate());
        hotelReservation.setCheckOutDate(reservationDTO.getCheckOutDate());
        hotelReservation.setNumberOfNights(reservationDTO.getNumberOfNights());
        hotelReservation.setTotal(reservationDTO.getTotal());
        hotelReservation.setExtraServices(services);
        // TODO Dodati kod korisnika ovu rezervaciju u listu rezervacija?
        hotelReservationService.createReservation(hotelReservation);
        }

       /* @RequestMapping(value = "/hotel-fast-reservations/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
        @Transactional
        @CrossOrigin(origins = "http://localhost:4200")
        public void makeFastReservation(@RequestBody FastHotelReservationDTO reservationDTO){
            FastHotelReservation reservation = new FastHotelReservation();
            reservation.setCheckInDate(reservationDTO.getCheckInDate());
            reservation.setCheckOutDate(reservationDTO.getCheckOutDate());
            reservation.setNumberOfNights(reservationDTO.getNumberOfNights());
            reservation.setTotal(reservationDTO.getTotal());
            Room room = roomService.findRoom(reservationDTO.getRoom());
            reservation.setRoom(room);
            Set<HotelServices> extraServices = new HashSet<>();
            for (Long i: reservationDTO.getExtraServices() ) {
                HotelServices hs = hotelService.getHotelService(i);
                if(hs!= null){
                    extraServices.add(hs);
                }
            }
            reservation.setUser(userService.findByUsername(reservationDTO.getUsername()));
            reservation.setExtraServices(extraServices);

            hotelReservationService.createFastReservation(reservation);
        }*/
    
        @RequestMapping(value = "/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public void updateUser() {



        }

}

