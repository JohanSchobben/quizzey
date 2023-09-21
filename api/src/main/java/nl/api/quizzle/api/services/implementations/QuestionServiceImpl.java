package nl.api.quizzle.api.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.models.Question;
import nl.api.quizzle.api.repositories.QuestionRepository;
import nl.api.quizzle.api.services.QuestionService;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question createQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(long id, Question question) {
        var questionOptional = this.questionRepository.findById(id);
        if(!questionOptional.isPresent()) {
            return null;
        }
        return questionOptional.get();
    }

    @Override
    public void deleteQuestion(long id) {
        this.questionRepository.deleteById(id);
    }
    
}
