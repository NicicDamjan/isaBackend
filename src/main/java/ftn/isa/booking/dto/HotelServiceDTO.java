package ftn.isa.booking.dto;

public class HotelServiceDTO {
    private  Long id;
    private String name;
    private Double cost;
    private  Long hotelId;

    public  HotelServiceDTO(){}

    public HotelServiceDTO(Long id, String name, Double cost, Long hotelId) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.hotelId = hotelId;
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

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

}
