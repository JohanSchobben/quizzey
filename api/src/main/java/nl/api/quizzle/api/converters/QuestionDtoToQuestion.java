package nl.api.quizzle.api.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import nl.api.quizzle.api.dtos.QuestionDto;
import nl.api.quizzle.api.models.Question;

@Component
public class QuestionDtoToQuestion implements Converter<QuestionDto, Question> {

    @Override
    public Question convert(QuestionDto source) {
        var question = new Question();

        question.setId(source.getId());
        question.setQuestion(source.getQuestion());
        question.setTags(question.getTags());
        question.setAnswers(String.join("|", source.getAnswers()));
        question.setAnswerIndex(source.getAnswers().indexOf(source.getCorrectAnswer()));

        return question;
    }
    
}
