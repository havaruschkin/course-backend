package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Chapter;
import by.home.courseback.service.ChapterService;
import by.home.courseback.service.dto.ChapterDTO;
import by.home.courseback.service.mapper.ChapterMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ChapterMapperImpl implements ChapterMapper {

    private final ChapterService chapterService;

    public ChapterMapperImpl(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @Override
    public List<Chapter> toChapters(Collection<ChapterDTO> chapterDTOs) {
        return chapterDTOs.stream()
                .map(chapterDTO -> chapterService.findChapter(chapterDTO.getId())
                ).collect(Collectors.toList());
    }

    @Override
    public List<ChapterDTO> toChapterDTOs(Collection<Chapter> chapters) {
        return chapters.stream()
                .map(this::toChapterDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChapterDTO toChapterDTO(Chapter chapter) {
        ChapterDTO chapterDTO = new ChapterDTO();
        chapterDTO.setId(chapter.getId());
        chapterDTO.setChapterName(chapter.getChapterName());
        chapterDTO.setText(chapter.getText());
        return chapterDTO;
    }

    @Override
    public Chapter toChapter(ChapterDTO chapterDTO) {
        Chapter chapter = new Chapter();
        chapter.setId(chapterDTO.getId());
        chapter.setChapterName(chapterDTO.getChapterName());
        chapter.setText(chapterDTO.getText());
        return chapter;
    }
}
