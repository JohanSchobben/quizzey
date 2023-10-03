package nl.api.quizzle.api.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import nl.api.quizzle.api.models.AuthUser;
import nl.api.quizzle.api.models.User;

@Component
public class UserToAuthUserConverter implements Converter<User, AuthUser> {

    @Override
    public AuthUser convert(User user) {
        AuthUser authUser = new AuthUser();
        authUser.setId(user.getId());
        authUser.setUsername(user.getUsername());
        authUser.setPassword(user.getPassword());
        authUser.setEmail(user.getEmail());
        authUser.setChangedAt(user.getChangedAt());
        authUser.setLastLogin(user.getLastLogin());
        authUser.setResetCode(user.getResetCode());
        authUser.setAccountNonExpired(user.isAccountNonExpired());
        authUser.setAccountNonLocked(user.isAccountNonLocked());
        authUser.setCredentialsNonExpired(user.isCredentialsNonExpired());
        authUser.setEnabled(user.isEnabled());
        return authUser;
    }
}
