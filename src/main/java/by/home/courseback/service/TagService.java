package by.home.courseback.service;

import by.home.courseback.model.Tag;
import by.home.courseback.repository.TagRepository;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Set<Tag> findAllTag() {
        return new HashSet<>(tagRepository.findAll());
    }

    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findTag(Long id) {
        return tagRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Optional<Tag> findTagByName(String name) {
        return tagRepository.findByTagName(name);
    }
}
