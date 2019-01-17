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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "HotelReservation")
public class HotelReservation {
    @Id
    @GeneratedValue
    private Long id;

    // svaka rezervacija ima jedan hotel, jedan isti hotel se moze pojaviti u vise razlicitih rezervacja ???
    /**
     * hotel( 0, N) --- (0,1)Rezervacija
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Hotel hotel;            // jednosmerna veza???


    // za svaku torku u tabeli rezervacija moze odgovarat vise torki iz tabele sobe, za svaku sobu u jednom trenutku
    // moze biti najvise jedna rezervacija???
    /**
     * soba(0,1) --- rezervacija(0,N)
     */
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Room> rooms;            // jednosmerna veza???


    // svaka rezervacija ima jednog korisnika, jedan isti korisnik se moze pojaviti u vise razlicitih rezervacja ???
    /**
     * korisnik( 0, N) --- (0,1)Rezervacija
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;              // u klasi User ce stajati OneToMany???
    @Column
    private LocalDate checkInDate;

    @Column
    private LocalDate checkOutDate;

    @Column
    private short numberOfNights;
    @Column
    private float total;

    // za svaku torku u tabeli rezervacija moze odgovarat vise torki iz tabele usluge, za svaku uslugu u jednom trenutku
    // moze biti najvise jedna rezervacija???
    // Svaki hotel ima listu usluga, sta sa ovim?
    /**
     * usluga( 0, N) --- (0,N)Rezervacija
     */
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<HotelServices> extraServices;   // jednosmerna veza???

    public HotelReservation() {
    }

    public HotelReservation(Hotel hotel, Set<Room> rooms, User user, LocalDate checkInDate,
                            LocalDate checkOutDate, short numberOfNights, float total,
                            Set<HotelServices> extraServices) {
        this.hotel = hotel;
        this.rooms = rooms;
        this.user = user;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
