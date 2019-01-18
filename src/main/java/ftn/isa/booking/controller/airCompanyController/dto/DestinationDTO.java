package ftn.isa.booking.controller.airCompanyController.dto;

public class DestinationDTO {

	private Long id;
	private String name;
	private String city;
	private String state;
	private String nick;

	public DestinationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DestinationDTO(String name, String city, String state, String nick) {
		super();
		this.name = name;
		this.city = city;
		this.state = state;
		this.nick = nick;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}




	
	
}
