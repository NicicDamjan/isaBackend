package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.HotelReservation;

@Repository
public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {

}
