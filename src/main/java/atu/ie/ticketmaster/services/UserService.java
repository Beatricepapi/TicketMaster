package atu.ie.ticketmaster.services;

import atu.ie.ticketmaster.model.User;
import atu.ie.ticketmaster.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered.");
        }
        return userRepository.save(user);
    }
}
