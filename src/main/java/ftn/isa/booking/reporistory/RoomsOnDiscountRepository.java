package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.RoomsOnDiscount;

@Repository
public interface RoomsOnDiscountRepository extends JpaRepository<RoomsOnDiscount,Long> {

}
