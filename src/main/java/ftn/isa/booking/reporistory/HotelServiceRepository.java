package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.HotelServices;

@Repository
public interface HotelServiceRepository extends JpaRepository<HotelServices, Long> {

}
