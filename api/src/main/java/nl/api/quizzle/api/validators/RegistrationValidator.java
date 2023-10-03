package nl.api.quizzle.api.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.dtos.RegisterForm;
import nl.api.quizzle.api.services.UserService;

@AllArgsConstructor
@Component
public class RegistrationValidator implements Validator {
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        var registerForm = (RegisterForm) target;
        var userWithUsername = this.userService.loadUserByUsername(registerForm.getUsername());
        var emailPattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        var specialKeyRegex = Pattern.compile("[!@#$^&*(){}-_+|\\=/€]");
        var numberRegex = Pattern.compile(".*\\d.*");

        if (registerForm.getUsername().isBlank()) {
            errors.rejectValue("username", "username.required");
        }
        if (registerForm.getPassword().isBlank()) {
            errors.rejectValue("password", "password.required");
        }
        if (registerForm.getEmail().isBlank()) {
            errors.rejectValue("email", "email.required");
        }
        if(userWithUsername == null) {
            errors.rejectValue("username", "username.not.unique");
        }
        if(emailPattern.matcher(registerForm.getEmail()).matches()) {
            errors.rejectValue("email", "email.not.valid");
        }
        if(registerForm.getPassword().length() < 8) {
            errors.rejectValue("password", "password.not.long");
        }
        if(specialKeyRegex.matcher(registerForm.getPassword()).matches()) {
            errors.rejectValue("password", "password.no.special.character");
        }
        if(registerForm.getPassword().equals(registerForm.getPassword().toLowerCase()) || registerForm.getPassword().equals(registerForm.getPassword().toUpperCase())) {
            errors.rejectValue("password", "password.not.casing");
        }
        if(numberRegex.matcher(registerForm.getPassword()).matches()) {
            errors.rejectValue("password", "password.no.number");
        }
    }
}
