package ftn.isa.booking.controller.airCompanyController.dto;

public class AirlineServicesDTO {

	private Long id;
    private String name;
    private Double price;
    private Long airlineId;
    
    
    
	public AirlineServicesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AirlineServicesDTO(Long id, String name, Double price, Long airlineId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.airlineId = airlineId;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Long airlineId) {
		this.airlineId = airlineId;
	} 
    
    
	
}
