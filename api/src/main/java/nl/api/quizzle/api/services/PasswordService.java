package nl.api.quizzle.api.services;

public interface PasswordService {
    byte[] getSalt();
    boolean validate(String password, String hashedPassword);
    String hash(String password);
}
