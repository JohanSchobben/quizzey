package nl.api.quizzle.api.services.implementations;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.models.User;
import nl.api.quizzle.api.repositories.UserRepository;
import nl.api.quizzle.api.services.UserService;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository.findOneByUsername(username);
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findOneByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User register(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void removeUser(long id) {
        this.userRepository.deleteById(id);
    }
}
