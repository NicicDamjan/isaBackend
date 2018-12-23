package ftn.isa.booking.reporistory;

import ftn.isa.booking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);
    User findOneByEmail(String email);
    User findOneByConfirmationToken(String token);
    
}
