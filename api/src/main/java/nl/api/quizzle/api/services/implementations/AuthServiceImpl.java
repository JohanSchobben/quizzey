package nl.api.quizzle.api.services.implementations;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.models.User;
import nl.api.quizzle.api.repositories.UserRepository;
import nl.api.quizzle.api.services.AuthService;

@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) throws UsernameNotFoundException {
        var user = this.userRepository.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + username + " not found.");
        }
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        // TODO respond incorrect password
        return null;
    }

    @Override
    public User register(String username, String email, String password) {
        var user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
