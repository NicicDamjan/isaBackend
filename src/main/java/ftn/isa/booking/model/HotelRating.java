package ftn.isa.booking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "HotelRatings")
public class HotelRating implements Serializable {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "Rating", nullable = false,unique = false)
    @Min(value = 0)
    @Max(value = 5)
    private double rating;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    private Hotel hotel;

    public HotelRating() {
    }

    public HotelRating(@Min(value = 0) @Max(value = 5) double rating, Hotel hotel) {
        this.rating = rating;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
