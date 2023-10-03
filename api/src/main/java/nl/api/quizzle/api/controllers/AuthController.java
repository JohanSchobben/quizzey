package nl.api.quizzle.api.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.converters.UserToUserDtoConverter;
import nl.api.quizzle.api.dtos.RegisterForm;
import nl.api.quizzle.api.dtos.UserDto;
import nl.api.quizzle.api.services.AuthService;
import nl.api.quizzle.api.validators.RegistrationValidator;

@AllArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {
    private AuthService authService;
    private UserToUserDtoConverter converter;
    private RegistrationValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }


    @PostMapping(path = "/register")
    public UserDto register(@Validated @RequestBody RegisterForm registerForm) {
        var user = this.authService.register(registerForm.getUsername(), registerForm.getEmail(), registerForm.getPassword());
        return this.converter.convert(user);
    }
}
