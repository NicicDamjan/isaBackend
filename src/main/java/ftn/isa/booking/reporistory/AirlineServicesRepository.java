package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;

import ftn.isa.booking.model.AirlineServices;


public interface AirlineServicesRepository extends JpaRepository<AirlineServices, Long> {

}
