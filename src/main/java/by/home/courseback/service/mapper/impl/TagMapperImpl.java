package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Tag;
import by.home.courseback.service.TagService;
import by.home.courseback.service.dto.TagDTO;
import by.home.courseback.service.mapper.TagMapper;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TagMapperImpl implements TagMapper {

    private final TagService tagService;

    public TagMapperImpl(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public Set<Tag> toTags(Set<TagDTO> tagDTOs) {
        return tagDTOs.stream()
                .map(tagDTO -> {
                    if (tagService.findTagByName(tagDTO.getName()).isPresent()) {
                        return tagService.findTag(tagDTO.getId());
                    }
                    return tagService.saveTag(toTag(tagDTO));
                }).collect(Collectors.toSet());
    }

    @Override
    public Set<TagDTO> toTagDTOs(Set<Tag> tags) {
        return tags.stream()
                .map(this::toTagDTO)
                .collect(Collectors.toSet());
    }

    @Override
    public TagDTO toTagDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getTagName());
        return tagDTO;
    }

    @Override
    public Tag toTag(TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setId(tagDTO.getId());
        tag.setTagName(tagDTO.getName());
        return tag;
    }
}
