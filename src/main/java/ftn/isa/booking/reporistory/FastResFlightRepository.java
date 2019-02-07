package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.FastFlightReservation;


@Repository
public interface FastResFlightRepository extends JpaRepository <FastFlightReservation, Long> {

}
