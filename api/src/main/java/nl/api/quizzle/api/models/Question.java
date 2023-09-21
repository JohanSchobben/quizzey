package nl.api.quizzle.api.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private String answers;
    private int answerIndex;
    @ManyToMany
    @JoinTable(name = "tags_questions", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;
}
