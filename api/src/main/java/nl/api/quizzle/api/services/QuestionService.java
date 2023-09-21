package nl.api.quizzle.api.services;

import java.util.List;

import nl.api.quizzle.api.models.Question;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question createQuestion(Question question);
    Question updateQuestion(long id, Question question);
    void deleteQuestion(long id);
}
