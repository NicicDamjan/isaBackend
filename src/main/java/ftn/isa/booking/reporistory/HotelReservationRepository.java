package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.isa.booking.model.HotelReservation;

public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {

}
