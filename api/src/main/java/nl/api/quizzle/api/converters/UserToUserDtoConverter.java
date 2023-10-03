package nl.api.quizzle.api.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import nl.api.quizzle.api.dtos.UserDto;
import nl.api.quizzle.api.models.User;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto>{

    @Override
    public UserDto convert(User source) {
        var dto = new UserDto();
        dto.setUsername(source.getUsername());
        dto.setEmail(source.getEmail());
        dto.setEnabled(source.isEnabled());
        dto.setLastLogin(source.getLastLogin());
        return dto;
    }
    
}
