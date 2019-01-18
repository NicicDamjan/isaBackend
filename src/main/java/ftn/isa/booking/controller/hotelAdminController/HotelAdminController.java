package ftn.isa.booking.controller.hotelAdminController;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ftn.isa.booking.dto.HotelDTO;
import ftn.isa.booking.dto.HotelRatingDTO;
import ftn.isa.booking.dto.HotelServiceDTO;
import ftn.isa.booking.dto.RoomDTO;
import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.model.HotelRating;
import ftn.isa.booking.model.HotelServices;
import ftn.isa.booking.model.Room;
import ftn.isa.booking.services.HotelService;
import ftn.isa.booking.services.RoomService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api")
public class HotelAdminController {

    @Autowired
    private  RoomService roomService;

    @Autowired
    private HotelService hotelService;


    @RequestMapping(value = "/hotels", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = HotelDTO.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @CrossOrigin(origins = "http://localhost:4200")
    public List<HotelDTO> findHotels(){
        List<HotelDTO> ret = new ArrayList<>();
        List<Hotel> hoteli = hotelService.findAllHotels();
        for (Hotel h: hoteli ) {
            HotelDTO hotel = new HotelDTO(h.getId(),h.getName(),h.getAddress(),h.getDesc(),h.getAvgRating());
            hotel.setCity(h.getCity());
            hotel.setCountry(h.getCountry());
            ret.add(hotel);
        }

        return ret;
    }

    @RequestMapping(value = "/hotels/{hotelId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Hotel.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @CrossOrigin(origins = "http://localhost:4200")
    public Hotel findHotel(@PathVariable Long hotelId){
        Hotel h = hotelService.findById(hotelId);
        if(h != null)
        return h;
        else {
            System.out.println("Greskaaaaaaaaaaaaaaaa");
            return  null;
        }
    }


    @RequestMapping(value = "/hotels/{hotelId}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public void editHotel(@RequestBody HotelDTO hotelDTO, @PathVariable Long hotelId){
        Hotel h = hotelService.findById(hotelId);
        h.setName(hotelDTO.getName());
        h.setAddress(hotelDTO.getAddress());
        h.setDesc(hotelDTO.getDesc());
        h.setCity(hotelDTO.getCity());
        h.setCountry(hotelDTO.getCountry());
        hotelService.editHotel(h);

    }

    //TODO Testirati!!!!

    @RequestMapping(value = "/rooms/{roomId}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete a room resource.", notes = "You have to provide a valid product ID in the URL. Once deleted the resource can not be recovered.", httpMethod = "DELETE")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Room.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteRoom(@ApiParam(value = "The ID of the existing product resource.", required = true) @PathVariable Long roomId) {
        Room room = roomService.findRoom(roomId);
        if(room != null){
            roomService.deleteRoom(roomId);
           // hotelService.deleteRoom(room);
        }
    }

    /*
        Dodavanje sobe hotela
     */
    @RequestMapping(value = "/hotels/{hotelId}/rooms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a room resource.", notes = "Returns the room being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Room.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public Room addRoom(@ApiParam(value = "The room object", required = true) @RequestBody RoomDTO roomDTO, @PathVariable Long hotelId){
        Hotel hotel = hotelService.findById(roomDTO.getHotelId());
        Room room = new Room(roomDTO.getCostPerNight(), roomDTO.isReserved(),roomDTO.getCapacity(), roomDTO.getFloor(),
                roomDTO.isHasBalcony(), hotel, new HashSet<>(), roomDTO.getRoomType(), roomDTO.getCostValidFrom(), roomDTO.getCostValidUntil());


        roomService.saveRoom(room);
        return room;
    }

    @RequestMapping(value = "/rooms/{roomId}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public Room editRoom(@RequestBody RoomDTO roomDTO, @PathVariable Long roomId){
        Room room = roomService.findRoom(roomId);
        if(room!= null && room.isReserved() == false){
            roomService.editRoom(roomDTO, room);
            return room;
        }
        return null;
    }

    /*
    Vraca sve usluge hotela
     */
    @RequestMapping(value = "/hotels/{hotelId}/services", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<HotelServiceDTO> getHotelServices(@PathVariable Long hotelId){
        List<HotelServiceDTO> ret = new ArrayList<>();
        List<HotelServices> all = hotelService.getServicesOfHotel(hotelId);
        for (HotelServices hs:all) {
            HotelServiceDTO pom = new HotelServiceDTO(hs.getId(), hs.getName(), hs.getCost(), hs.getH().getId());
            ret.add(pom);
        }
        return ret;
    }

    @RequestMapping(value = "/hotels/{hotelId}/services/{serviceId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin(origins = "http://localhost:4200")
    public HotelServiceDTO getHotelService(@PathVariable Long hotelId, @PathVariable Long  serviceId){
        HotelServices pom = hotelService.getHotelService(serviceId);
        if(pom!= null){
            HotelServiceDTO ret = new HotelServiceDTO(pom.getId(), pom.getName(), pom.getCost(), pom.getH().getId());
            return  ret;
        }
        return null;
    }

    /*
        Dodavanje nove usluge hotela
     */
    @RequestMapping(value = "/hotels/{hotelId}/services", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a service resource.", httpMethod = "POST", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = HotelService.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public void addServiceToHotel(@ApiParam(value = "The hotel service object", required = true) @RequestBody HotelServiceDTO s, @PathVariable Long hotelId){
        HotelServices hs = new HotelServices();
        hs.setCost(s.getCost());
        hs.setName(s.getName());

        Hotel h = hotelService.findById(hotelId);
        hs.setH(h);
        hotelService.addService(hs);
    }

    @RequestMapping(value = "/hotels/{hotelId}/services/{serviceId}", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean editHotelService(@RequestBody HotelServiceDTO hsDto, @PathVariable Long hotelId, @PathVariable Long serviceId){
        boolean ret = false;
        HotelServices hs = new HotelServices();
        hs.setId(serviceId);
        hs.setName(hsDto.getName());
        hs.setCost(hsDto.getCost());
        Hotel h = hotelService.findById(hotelId);
        if (h!= null){
            hs.setH(h);
            hotelService.addService(hs);
            ret = true;
        }
        return  ret;

    }

    /*
        Uklanja hotelsku uslugu
     */
    @RequestMapping(value = "/hotels/{hotelId}/services/{serviceId}", method = RequestMethod.DELETE)
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteHotelService(@ApiParam(value = "The ID of the existing product resource.", required = true) @PathVariable Long hotelId, @PathVariable Long serviceId) {
        this.hotelService.deleteHotelService(serviceId);
    }

    /*
        Dodavanje nove ocene hotela(Ovo koristi registrovan korisnik)
     */
    @RequestMapping(value = "/ratings/{hotelId}", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a service resource.", notes = "Returns the service being saved.", httpMethod = "POST", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = HotelService.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 500, message = "Failure") })
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public HotelRating addRatingToHotel(@ApiParam(value = "The room object", required = true) @RequestBody HotelRatingDTO hr, @PathVariable Long hotelId){
        HotelRating hotelRating = new HotelRating();
       hotelRating.setRating(hr.getRating());
       hotelRating.setHotel(hotelService.findById(hotelId));

        return  hotelService.rateHotel(hotelRating, hotelId);

    }

    /*
        Prikaz prosecne ocene hotela - koristi admin
     */
    @RequestMapping(value = "/ratings/averege-rating/{hotelId}", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public double getHotelRating( @PathVariable Long hotelId){
        Hotel h = hotelService.findById(hotelId);
         return h.getAvgRating();
    }

}