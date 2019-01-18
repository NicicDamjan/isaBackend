package ftn.isa.booking.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Hotels")
public class Hotel implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Column(name = "Address", nullable = false)
	private  String address;

	@Column(name = "City", nullable = false)
	private String city;

	//@Column(name = "Post code", nullable = false)
   // private String zip;
	@Column(name = "Country", nullable = false)
    private String country;

	@Column(name = "Description", nullable = true)
	private String desc;
	
	@Column(name = "admin", nullable = true)
	private String admin;


	@OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Room> rooms;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy ="h" )
	private  Set<HotelServices> services;

	@OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private  Set<HotelRating> allRatings;

	@Transient
	@JsonIgnore
	private double avgRating=0.0;

	public Hotel(){
		rooms = new HashSet<>();
		services = new HashSet<>();
		allRatings = new HashSet<>();

	}

	public Hotel(String name, String address, String desc, String admin, Set<Room> rooms, Set<HotelServices> services, Set<HotelRating> allRatings) {
		this.name = name;
		this.address = address;
		this.desc = desc;
		this.rooms = rooms;
		this.services = services;
		this.allRatings = allRatings;
		this.admin = admin;
	}

	
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<HotelServices> getServices() {
		return services;
	}

	public void setServices(Set<HotelServices> services) {
		this.services = services;
	}

	public Set<HotelRating> getAllRatings() {
		return allRatings;
	}

	public void setAllRatings(Set<HotelRating> allRatings) {
		this.allRatings = allRatings;
	}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonIgnore
	public double getAvgRating() {
		avgRating =0;
		for (HotelRating hr: allRatings){
			avgRating+=hr.getRating();
		}

		if(Double.isNaN(avgRating) || allRatings.size() == 0)
		    return 0.0;
		return avgRating/((double)allRatings.size());
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
}
