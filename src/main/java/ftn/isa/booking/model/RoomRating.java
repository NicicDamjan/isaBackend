package ftn.isa.booking.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "RoomRatings")
public class RoomRating {
    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "Rating", nullable = false,unique = false)
    @Min(value = 0)
    @Max(value = 5)
    private double rating;

    @ManyToOne( fetch = FetchType.LAZY)
    @JsonIgnore
    private  Room room;

    public RoomRating(@Min(value = 0) @Max(value = 5) double rating, Room room) {
        this.rating = rating;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
