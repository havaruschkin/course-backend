package by.home.courseback.service.mapper;

import by.home.courseback.model.Chapter;
import by.home.courseback.service.dto.ChapterDTO;
import java.util.Collection;
import java.util.List;

public interface ChapterMapper {

    List<Chapter> toChapters(Collection<ChapterDTO> chapters);

    List<ChapterDTO> toChapterDTOs(Collection<Chapter> chapters);

    ChapterDTO toChapterDTO(Chapter chapter);

    Chapter toChapter(ChapterDTO chapterDTO);
}
