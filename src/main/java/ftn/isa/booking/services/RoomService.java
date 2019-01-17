package ftn.isa.booking.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.dto.RoomDTO;
import ftn.isa.booking.model.Room;
import ftn.isa.booking.reporistory.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public  void editRoom(RoomDTO roomDTO, Room room){

        room.setReserved(roomDTO.isReserved());
        room.setCostPerNight(roomDTO.getCostPerNight());
        room.setCapacity(roomDTO.getCapacity());
        room.setHasBalcony(roomDTO.isHasBalcony());
        room.setRoomType(roomDTO.getRoomType());
        room.setFloor(roomDTO.getFloor());
        if(room.isHasBalcony())
            room.setBalkon("Da");
        else
            room.setBalkon("Ne");
        room.setCostValidFrom(roomDTO.getCostValidFrom());
        room.setCostValidUntil(roomDTO.getCostValidUntil());

        roomRepository.save(room);
    }

    public  void deleteRoom(Long id){
        Room r = roomRepository.findById(id).get();
        if(!r.isReserved())
        roomRepository.deleteById(id);
    }

    public Room findRoom(Long id){
        Room r =null;
        if (roomRepository.findById(id).isPresent()){
            r= roomRepository.findById(id).get();
        }
        return  r;
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public List<Room> findAllRooms(){
         return roomRepository.findAll();
    }
}
