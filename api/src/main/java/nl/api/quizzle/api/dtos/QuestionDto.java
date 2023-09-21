package nl.api.quizzle.api.dtos;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDto {
    private long id;
    private String question;
    private List<String> answers;
    private String correctAnswer;
    private List<String> tags;
}
