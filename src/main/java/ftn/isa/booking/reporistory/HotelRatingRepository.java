package ftn.isa.booking.reporistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.isa.booking.model.HotelRating;

@Repository
public interface HotelRatingRepository extends JpaRepository<HotelRating, Long> {

}
