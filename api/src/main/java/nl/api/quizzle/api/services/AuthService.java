package nl.api.quizzle.api.services;

import nl.api.quizzle.api.models.User;

public interface AuthService {
    User login(String username, String password);
    User register(String username, String email, String password);
}
