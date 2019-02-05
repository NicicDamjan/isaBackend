package ftn.isa.booking.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class RoomsOnDiscount {

	 @Id
	    @GeneratedValue
	    private Long id;

	    @Column(name = "costValidFrom", nullable = false)
	    private LocalDate costValidFrom;

	    @Column(name = "costValidUntil", nullable = false)
	    private LocalDate costValidUntil;

	    @Column(nullable = false)
	    private double originalCost;

	    @Column(nullable = false)
	    private double discountCost;

	    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private Room room;

	    @ManyToMany(fetch = FetchType.LAZY)
	    private Set<HotelServices> extraServices;

	    public RoomsOnDiscount() {
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
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

	    public double getOriginalCost() {
	        return originalCost;
	    }

	    public void setOriginalCost(double originalCost) {
	        this.originalCost = originalCost;
	    }

	    public double getDiscountCost() {
	        return discountCost;
	    }

	    public void setDiscountCost(double discountCost) {
	        this.discountCost = discountCost;
	    }

	    public Room getRoom() {
	        return room;
	    }

	    public void setRoom(Room room) {
	        this.room = room;
	    }

	    public Set<HotelServices> getExtraServices() {
	        return extraServices;
	    }

	    public void setExtraServices(Set<HotelServices> extraServices) {
	        this.extraServices = extraServices;
	    }
	}
