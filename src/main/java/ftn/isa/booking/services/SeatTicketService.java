package ftn.isa.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.isa.booking.reporistory.SeatTicketRepository;


@Service
public class SeatTicketService {

	@Autowired
	private SeatTicketRepository seatTicketRepository;
	
}
