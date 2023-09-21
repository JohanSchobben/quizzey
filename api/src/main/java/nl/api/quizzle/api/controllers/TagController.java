package nl.api.quizzle.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import nl.api.quizzle.api.models.Tag;
import nl.api.quizzle.api.repositories.projections.TagProjection;
import nl.api.quizzle.api.services.TagService;

@AllArgsConstructor
@RestController
@RequestMapping("tags")
public class TagController {
    private TagService tagService;

    @GetMapping
    public List<TagProjection> getAllTags() {
        return this.tagService.getTags();
    }

    @PostMapping
    public Tag createTag(@RequestBody Tag body) {
        return this.tagService.createTag(body);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTag(@PathVariable long id) {
        this.tagService.removeTag(id);
    }
}
