package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Hotel;
import ftn.isa.booking.model.User;

@Repository
public interface HotelsRepository extends JpaRepository<Hotel, Long> {
	
	Hotel findOneById(Long id);
	Hotel findOneByName(String name);
}
