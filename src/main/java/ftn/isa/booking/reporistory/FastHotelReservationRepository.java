package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.FastHotelReservation;

@Repository
public interface FastHotelReservationRepository extends JpaRepository<FastHotelReservation, Long> {


}