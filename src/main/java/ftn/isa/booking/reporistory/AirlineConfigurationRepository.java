package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.AirlineConfiguration;


@Repository
public interface AirlineConfigurationRepository extends JpaRepository<AirlineConfiguration, Long> {

}
