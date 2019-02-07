package ftn.isa.booking.dto;

import java.time.LocalDate;

import ftn.isa.booking.enums.RoomType;

public class RoomOnDiscountDTO {
	private  Long id;
    private  boolean reserved;
    private float costPerNight;
    private  Long hotelId;
    private int capacity;
    private  int floor;
    private  boolean hasBalcony;
    private String balkon;
    private RoomType roomType;
    private LocalDate costValidFrom;
    private LocalDate costValidUntil;
    private LocalDate reservedFrom = null;
    private LocalDate reservedUntil = null;
    private double originalPrice;

    public RoomOnDiscountDTO(Long id, boolean reserved, float costPerNight, Long hotelId, int capacity, int floor, boolean hasBalcony, RoomType roomType, LocalDate costValidFrom, LocalDate costValidUntil, double originalPrice) {

        this.id = id;
        this.reserved = reserved;
        this.costPerNight = costPerNight;
        this.hotelId = hotelId;
        this.capacity = capacity;
        this.floor = floor;
        this.hasBalcony = hasBalcony;
        this.roomType = roomType;
        if(hasBalcony){
            balkon = "Da";
        }else{
            balkon = "Ne";
        }
        this.costValidFrom = costValidFrom;
        this.costValidUntil = costValidUntil;
        this.originalPrice = originalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public float getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(float costPerNight) {
        this.costPerNight = costPerNight;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
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

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
}
