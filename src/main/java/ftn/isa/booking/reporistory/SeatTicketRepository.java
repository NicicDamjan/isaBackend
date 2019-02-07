package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.SeatTicket;


@Repository
public interface SeatTicketRepository extends JpaRepository<SeatTicket, Long> {

}
