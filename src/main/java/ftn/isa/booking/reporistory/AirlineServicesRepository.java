package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.AirlineServices;

@Repository
public interface AirlineServicesRepository extends JpaRepository<AirlineServices, Long> {

}
