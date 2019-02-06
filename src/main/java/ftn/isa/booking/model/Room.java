package ftn.isa.booking.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ftn.isa.booking.enums.RoomType;

@Entity(name = "Rooms")
public class Room implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "CostPerNight")
    private float costPerNight;

    @Column(name = "Occupied")
    private  boolean reserved;
    @Column
    private int capacity;

    @Column
    private LocalDate reservedFrom;

    @Column
    private LocalDate reservedUntil;

    @Column
    private  int floor;

    @Column
    private  boolean hasBalcony;

    // TODO provjeriti
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Hotel hotel;

    @OneToMany(mappedBy = "room",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RoomRating> allRatings;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(name = "CenaVaziOd")
    private LocalDate costValidFrom;

    @Column(name = "CenaVaziDo")
    private LocalDate costValidUntil;
    
    @Column(nullable = false)
    private boolean active = true;
    /*
     * Za primer optimistickog zakljucavanja, Spring i EJB koriste posebnu anotaciju
     * @Version kojom se anotira obicno integer polje koje se pri svakoj promeni entiteta
     * povecava za 1. Svaki klijent ce dobiti i informaciju o verziji podatka.
     * Prilikom izmene podatka potrebno je proveriti da li je podatke neko drugi u medjuvremenu menjao:
     * - poredi se verzija podatka koju je klijent procitao sa onim sto se trenutno nalazi u bazi
     * - poredjenje se vrsi pri commit-u transakcije (normal validation)
     *   ili pri svakom pisanju u bazu u toku transakcije (early validation)
     * - ako su podaci menjani prijavlje se greska korisniku
     */
    @Version
    private Long version;   // Treba zbog rezervacije sobe
    @Transient
    private String balkon;

    public Room(){
    allRatings = new HashSet<>();
    }

    public Room(float costPerNight, boolean reserved, int capacity, int floor, boolean hasBalcony, Hotel hotel,
                Set<RoomRating> allRatings, RoomType roomType, LocalDate cvf, LocalDate cvu) {
        this.costPerNight = costPerNight;
        this.reserved = reserved;
        this.capacity = capacity;

        this.floor = floor;
        this.hasBalcony = hasBalcony;
        this.hotel = hotel;
        this.allRatings = allRatings;
        this.roomType = roomType;
        if(hasBalcony){
            balkon = "Da";
        }else {
            balkon = "Ne";
        }
        this.costValidFrom = cvf;
        this.costValidUntil = cvu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(float costPerNight) {
        this.costPerNight = costPerNight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<RoomRating> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(Set<RoomRating> allRatings) {
        this.allRatings = allRatings;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public String getBalkon() {
        return balkon;
    }

    public void setBalkon(String balkon) {
        this.balkon = balkon;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public LocalDate getCostValidFrom() {
        return costValidFrom;
    }

    public void setCostValidFrom(LocalDate costValidFrom) {
        this.costValidFrom = costValidFrom;
    }

    public LocalDate getCostValidUntil() {
        return costValidUntil;
    }

    public void setCostValidUntil(LocalDate costValidUntil) {
        this.costValidUntil = costValidUntil;
    }

	public LocalDate getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(LocalDate reservedFrom) {
		this.reservedFrom = reservedFrom;
	}

	public LocalDate getReservedUntil() {
		return reservedUntil;
	}

	public void setReservedUntil(LocalDate reservedUntil) {
		this.reservedUntil = reservedUntil;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
    
    

}
