package ftn.isa.booking.services;

import ftn.isa.booking.model.User;
import ftn.isa.booking.reporistory.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    public User getOne(Long id) {
        return usersRepository.findOneById(id);
    }
}
