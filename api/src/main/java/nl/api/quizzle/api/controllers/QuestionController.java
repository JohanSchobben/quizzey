package nl.api.quizzle.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.converters.QuestionDtoToQuestion;
import nl.api.quizzle.api.converters.QuestionToQuestioDto;
import nl.api.quizzle.api.dtos.QuestionDto;
import nl.api.quizzle.api.services.QuestionService;
import nl.api.quizzle.api.validators.QuestionValidator;


@AllArgsConstructor
@RestController
@RequestMapping("questions")
public class QuestionController {
    private QuestionService questionService;
    private QuestionToQuestioDto questionToQuestioDto;
    private QuestionDtoToQuestion questionDtoToQuestion;
    private QuestionValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }

    @GetMapping
    public List<QuestionDto> getAllQuestions() {
        var questions = this.questionService.getAllQuestions();
        List<QuestionDto> questionDtos = new ArrayList<>();

        for (var question : questions) {
            questionDtos.add(this.questionToQuestioDto.convert(question));
        }
        return questionDtos;
    }

    @PostMapping
    public QuestionDto createTag(@Validated @RequestBody QuestionDto body) {
        var question = this.questionDtoToQuestion.convert(body);
        var dto = this.questionToQuestioDto.convert(this.questionService.createQuestion(question));
        return dto;
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteTag(@PathVariable long id) {
        this.questionService.deleteQuestion(id);
    }
}
