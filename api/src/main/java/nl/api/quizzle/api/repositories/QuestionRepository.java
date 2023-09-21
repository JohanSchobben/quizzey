package nl.api.quizzle.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.api.quizzle.api.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
    
}
