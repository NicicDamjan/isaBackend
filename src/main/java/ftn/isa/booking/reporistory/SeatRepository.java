package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.Seat;


@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>  {

}
