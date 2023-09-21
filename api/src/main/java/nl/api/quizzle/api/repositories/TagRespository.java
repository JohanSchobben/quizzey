package nl.api.quizzle.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nl.api.quizzle.api.models.Tag;
import nl.api.quizzle.api.repositories.projections.TagProjection;

@Repository
public interface TagRespository extends JpaRepository<Tag, Long>  {
    
    @Query("SELECT t.id as id, t.name as name FROM tags t")
    List<TagProjection> findAllTagsWithoutQuestion();
}
