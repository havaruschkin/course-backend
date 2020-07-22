package by.home.courseback.service.mapper;

import by.home.courseback.model.Tag;
import by.home.courseback.service.dto.TagDTO;
import java.util.Set;

public interface TagMapper {

    Set<Tag> toTags(Set<TagDTO> tags);

    Set<TagDTO> toTagDTOs(Set<Tag> tags);

    TagDTO toTagDTO(Tag tag);

    Tag toTag(TagDTO tagDTO);
}
