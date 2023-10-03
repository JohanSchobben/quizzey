package nl.api.quizzle.api.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private String username;
    private String email;
    private Date lastLogin;
    private boolean isEnabled;
}
