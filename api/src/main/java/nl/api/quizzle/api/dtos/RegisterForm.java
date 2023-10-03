package nl.api.quizzle.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterForm {
    private String username;
    private String email;
    private String password;
}
