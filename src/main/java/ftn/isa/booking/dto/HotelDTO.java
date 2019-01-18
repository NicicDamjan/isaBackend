package ftn.isa.booking.dto;

public class HotelDTO {

    private Long id;
    private String name;
    private String address;
    private String desc;
    private double avgRating;
    private String city;
    private String country;

    public HotelDTO() {
        avgRating = 0;
    }

    public HotelDTO(Long id, String name, String address, String desc, double avgRating) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.desc = desc;
        this.avgRating = avgRating;
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

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;

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
}