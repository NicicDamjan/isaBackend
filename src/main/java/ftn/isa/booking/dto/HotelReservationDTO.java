package ftn.isa.booking.dto;

import java.time.LocalDate;
import java.util.Set;

public class HotelReservationDTO {
    private Long id;
    private Long hotelId;
    private Set<Long> rooms;
    private String username;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private short numberOfNights;
    private float total;
    private Set<Long> extraServices;

    public HotelReservationDTO(Long id, Long hotelId, Set<Long> rooms, String username, LocalDate checkInDate,
                               LocalDate checkOutDate, short numberOfNights, float total, Set<Long> extraServices) {
        this.id = id;
        this.hotelId = hotelId;
        this.rooms = rooms;
        this.username = username;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfNights = numberOfNights;
        this.total = total;
        this.extraServices = extraServices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Set<Long> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Long> rooms) {
        this.rooms = rooms;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userId) {
        this.username = userId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public short getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(short numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Set<Long> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(Set<Long> extraServices) {
        this.extraServices = extraServices;
    }
}
