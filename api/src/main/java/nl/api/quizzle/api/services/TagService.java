package nl.api.quizzle.api.services;

import java.util.List;

import nl.api.quizzle.api.models.Tag;
import nl.api.quizzle.api.repositories.projections.TagProjection;

public interface TagService {
    List<TagProjection> getTags();
    Tag createTag(Tag tag);
    Tag renameTag(long id, String newName);
    void removeTag(long id);
}
