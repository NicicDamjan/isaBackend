package ftn.isa.booking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "HotelServices")
public class HotelServices implements Serializable {

    @Id
    @GeneratedValue
    private  Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Cost", nullable = false)
    private Double cost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Hotel h;

    public HotelServices() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Hotel getH() {
        return h;
    }

    public void setH(Hotel h) {
        this.h = h;
    }
}
