package ftn.isa.booking.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FastHotelReservation {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    private  Room room;
    @Column
    private LocalDate checkInDate;

    @Column
    private LocalDate checkOutDate;

    @Column
    private short numberOfNights;
    @Column
    private float total;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<HotelServices> extraServices;


    public FastHotelReservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public Set<HotelServices> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(Set<HotelServices> extraServices) {
        this.extraServices = extraServices;
    }
}
