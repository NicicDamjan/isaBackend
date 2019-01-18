package ftn.isa.booking.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "Airlines")
public class Airline implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="Name")
	private String name;

	@Column(name="Address")
	private String address;

	@Column(name="Description")
	private String description;

	@ManyToMany(mappedBy = "airlines", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Destination> destinations = new LinkedHashSet<Destination>();

	@OneToMany(mappedBy = "airline", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Flight> flights = new HashSet<Flight>(); 

	@OneToMany(mappedBy = "airline", fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	private Set<DiscountTicket> discountTickets = new HashSet<DiscountTicket>();
	
	@OneToMany(mappedBy = "airline", fetch = FetchType.EAGER, cascade = CascadeType.ALL) 
	private Set<AirlineServices> airlineServices = new LinkedHashSet<AirlineServices>();


	
	@OneToOne(fetch = FetchType.EAGER)
	private AirlineConfiguration airlineConfiguration;


	//@Column(name="Price List and info")
	//private Set<String> priceList;
	
	@Column(name="AverageGrade")
	private double averageGrade;

	public  Airline(){
		
	}
	
	public Airline(String name, String address, String description, Set<Destination> destinations, Set<Flight> flights) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
		this.destinations = destinations;
		this.flights = flights;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}

	public Set<Flight> getFlights() {
		return flights;
	}

	public void setFlights(Set<Flight> flights) {
		this.flights = flights;
	}
	
	public void addFlights(Flight flight) {
		this.flights.add(flight);
	}
	
	public void removeFlights(Flight flight) {
		this.flights.remove(flight);
	}

	public Set<DiscountTicket> getDiscountTickets() {
		return discountTickets;
	}

	public void setDiscountTickets(Set<DiscountTicket> discountTickets) {
		this.discountTickets = discountTickets;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public Set<AirlineServices> getAirlineServices() {
		return airlineServices;
	}

	public void setAirlineServices(Set<AirlineServices> airlineServices) {
		this.airlineServices = airlineServices;
	}

	public AirlineConfiguration getAirlineConfiguration() {
		return airlineConfiguration;
	}

	public void setAirlineConfiguration(AirlineConfiguration airlineConfiguration) {
		this.airlineConfiguration = airlineConfiguration;
	}
	
	
	
	
}
