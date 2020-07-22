package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Composition;
import by.home.courseback.service.CompositionService;
import by.home.courseback.service.GenreService;
import by.home.courseback.service.dto.CompositionDTO;
import by.home.courseback.service.mapper.ChapterMapper;
import by.home.courseback.service.mapper.CommentMapper;
import by.home.courseback.service.mapper.CompositionMapper;
import by.home.courseback.service.mapper.GenreMapper;
import by.home.courseback.service.mapper.TagMapper;
import by.home.courseback.service.mapper.UserMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CompositionMapperImpl implements CompositionMapper {

    private final GenreService genreService;
    private final GenreMapper genreMapper;
    private final ChapterMapper chapterMapper;
    private final TagMapper tagMapper;
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;
    private final CompositionService compositionService;

    public CompositionMapperImpl(GenreService genreService, GenreMapper genreMapper,
                                 ChapterMapper chapterMapper, TagMapper tagMapper,
                                 CommentMapper commentMapper, UserMapper userMapper,
                                 CompositionService compositionService) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
        this.chapterMapper = chapterMapper;
        this.tagMapper = tagMapper;
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
        this.compositionService = compositionService;
    }

    @Override
    public List<Composition> toCompositions(Collection<CompositionDTO> compositionDTOS) {
        return compositionDTOS.stream()
                .map(compositionDTO -> compositionService.findComposition(compositionDTO.getId())
                ).collect(Collectors.toList());
    }

    @Override
    public List<CompositionDTO> toCompositionDTOs(List<Composition> compositions) {
        return compositions.stream()
                .map(this::toCompositionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompositionDTO toCompositionDTO(Composition composition) {
        CompositionDTO compositionDTO = new CompositionDTO();
        compositionDTO.setId(composition.getId());
        compositionDTO.setCompositionName(composition.getCompositionName());
        compositionDTO.setDescription(composition.getDescription());
        compositionDTO.setGenre(genreMapper.toGenreDTO(composition.getGenre()));
        compositionDTO.setTags(tagMapper.toTagDTOs(composition.getTags()));
        compositionDTO.setChapters(chapterMapper.toChapterDTOs(composition.getChapters()));
        compositionDTO.setComments(commentMapper.toCommentDTOs(composition.getComments()));
        compositionDTO.setCreatedAt(composition.getCreatedAt());
        compositionDTO.setUpdatedAt(composition.getUpdatedAt());
        compositionDTO.setUser(userMapper.toUserDTO(composition.getUser()));
        compositionDTO.setUrlImage(composition.getUrlImage());
        compositionDTO.setAltImage(composition.getAltImage());
        return compositionDTO;
    }

    @Override
    public Composition toComposition(CompositionDTO compositionDTO) {
        Composition composition = new Composition();
        composition.setId(compositionDTO.getId());
        composition.setCompositionName(compositionDTO.getCompositionName());
        composition.setDescription(compositionDTO.getDescription());
        composition.setGenre(genreService.findGenre(compositionDTO.getGenre().getId()));
        composition.setTags(tagMapper.toTags(compositionDTO.getTags()));
        composition.setChapters(chapterMapper.toChapters(compositionDTO.getChapters()));
        composition.setComments(commentMapper.toComments(compositionDTO.getComments()));
        composition.setCreatedAt(compositionDTO.getCreatedAt());
        composition.setUpdatedAt(compositionDTO.getUpdatedAt());
        composition.setUrlImage(compositionDTO.getUrlImage());
        composition.setAltImage(compositionDTO.getAltImage());
        return composition;
    }
}
