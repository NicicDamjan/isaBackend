package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.isa.booking.model.HotelServices;

public interface HotelServiceRepository extends JpaRepository<HotelServices, Long> {

}
