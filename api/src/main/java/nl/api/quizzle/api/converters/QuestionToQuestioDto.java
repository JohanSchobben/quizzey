package nl.api.quizzle.api.converters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import nl.api.quizzle.api.dtos.QuestionDto;
import nl.api.quizzle.api.models.Question;

@Component
public class QuestionToQuestioDto implements Converter<Question, QuestionDto> {

    @Override
    public QuestionDto convert(Question source) {
        var questionsList = Arrays.asList(source.getAnswers().split("||"));
        var questionDto =  new QuestionDto();
        List<String> tags = new ArrayList<>();

        if (source.getTags() != null) {
            for(var tag: source.getTags()) {
                tags.add(tag.getName());
            }
        }


        questionDto.setId(source.getId());
        questionDto.setAnswers(questionsList);
        questionDto.setCorrectAnswer(questionsList.get(source.getAnswerIndex()));
        questionDto.setTags(tags);

        return questionDto;
    }
    
}
