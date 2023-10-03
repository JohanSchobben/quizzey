package nl.api.quizzle.api.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import nl.api.quizzle.api.models.User;

public interface UserService extends UserDetailsService {
    public User getUser(String username);
    public List<User> getAllUsers();
    public User register(User user);
    public void removeUser(long id);
}
