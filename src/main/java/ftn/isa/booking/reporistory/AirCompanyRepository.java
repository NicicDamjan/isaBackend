package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.AirCompany;

@Repository
public interface AirCompanyRepository extends JpaRepository<AirCompany, Long> {
	
    AirCompany findOneById(Long id);
    AirCompany findOneByName(String name);

}
