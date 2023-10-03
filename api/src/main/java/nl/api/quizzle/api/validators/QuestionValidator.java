package nl.api.quizzle.api.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import nl.api.quizzle.api.dtos.QuestionDto;

@Component
public class QuestionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("Validation");
        // method only called if supports returns true
        var questionDto = (QuestionDto) target;
        if (questionDto.getQuestion().isBlank()) {
            errors.rejectValue("question", "question.empty");
        }
        if (questionDto.getQuestion().length() > 50) {
            errors.rejectValue("question", "question.size");
        }
        if(questionDto.getAnswers().size() > 12) {
            errors.rejectValue("answers", "answer.toomany");
        }
        if(questionDto.getAnswers().size() < 4) {
            errors.rejectValue("answers", "answer.toless");
        }
        if(!questionDto.getAnswers().stream().anyMatch(questionDto.getAnswers()::equals)) {
            System.out.println("hier index of");
            errors.rejectValue("correctAnswer", "correctAnswer.notEqual");
        }
    }
}
