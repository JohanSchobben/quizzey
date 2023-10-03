package nl.api.quizzle.api.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.models.Tag;
import nl.api.quizzle.api.repositories.TagRepository;
import nl.api.quizzle.api.repositories.projections.TagProjection;
import nl.api.quizzle.api.services.TagService;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {
    private TagRepository respository;

    @Override
    public List<TagProjection> getTags() {
        return this.respository.findAllTagsWithoutQuestion();
    }

    @Override
    public Tag createTag(Tag tag) {
        return this.respository.save(tag);
    }

    @Override
    public Tag renameTag(long id, String newName) {
        Optional<Tag> tag = this.respository.findById(id);

        if (tag.isPresent()) {
            tag.get().setName(newName);
            this.respository.save(tag.get());
        }

        return null;
    }

    @Override
    public void removeTag(long id) {
        this.respository.deleteById(id);
    }
    
}
