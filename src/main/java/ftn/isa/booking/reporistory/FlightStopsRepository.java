package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.FlightStops;

@Repository
public interface FlightStopsRepository extends JpaRepository<FlightStops, Long> {

}
