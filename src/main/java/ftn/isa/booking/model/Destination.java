package ftn.isa.booking.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Destinations")
public class Destination {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name="Nick")
	private String nick;
	
	@Column(name="City")
	private String city;
	
	@Column(name="State")
	private String state;
	
	//@OneToMany(mappedBy="fromDest", fetch = FetchType.EAGER)
	//private Set<Flight> from = new HashSet<Flight>();
	
	//@OneToMany(mappedBy="toDest", fetch = FetchType.EAGER)
	//private Set<Flight> to = new HashSet<Flight>();
	
	@ManyToMany( fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinTable(name="DestinationsAndAirlines", 
				joinColumns=@JoinColumn(name="destination_id", referencedColumnName="id"),
				inverseJoinColumns = @JoinColumn(name="airline_id", referencedColumnName="id"))
	private Set<Airline> airlines = new LinkedHashSet<Airline>();
	
//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Set<Flight> fromDest = new HashSet<Flight>();
	

	//@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Set<Flight> toDest = new HashSet<Flight>();
	
	
	public Destination() {

	}
	
	
	public Destination(String name, String nick, String city, String state /* Set<Flight> from, Set<Flight> to,*/
) {
	super();
	this.name = name;
	this.nick = nick;
	this.city = city;
	this.state = state;
	//this.from = from;
//	this.to = to;
//	this.airlines = airlines;
}




	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}


/*
	public Set<Flight> getFrom() {
		return from;
	}



	public void setFrom(Set<Flight> from) {
		this.from = from;
	}



	public Set<Flight> getTo() {
		return to;
	}



	public void setTo(Set<Flight> to) {
		this.to = to;
	}

*/

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

	public Set<Airline> getAirlines() {
		return airlines;
	}

	public void setAirlines(Set<Airline> airlines) {
		this.airlines = airlines;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	
	

}
