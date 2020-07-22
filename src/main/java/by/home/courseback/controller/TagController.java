package by.home.courseback.controller;

import by.home.courseback.service.TagService;
import by.home.courseback.service.dto.TagDTO;
import by.home.courseback.service.mapper.TagMapper;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tag")
public class TagController {

    private final TagService tagService;
    private final TagMapper tagMapper;

    public TagController(TagService tagService, TagMapper tagMapper) {
        this.tagService = tagService;
        this.tagMapper = tagMapper;
    }

    @GetMapping
    public Set<TagDTO> allTags() {
        return tagMapper.toTagDTOs(tagService.findAllTag());
    }

    @GetMapping("/{id}")
    public TagDTO getTag(@PathVariable Long id) {
        return tagMapper.toTagDTO(tagService.findTag(id));
    }
}
