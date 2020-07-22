package by.home.courseback.controller;

import by.home.courseback.exeption.CreatedEntityIdException;
import by.home.courseback.exeption.UpdatedEntityIdException;
import by.home.courseback.service.ChapterService;
import by.home.courseback.service.dto.ChapterDTO;
import by.home.courseback.service.mapper.ChapterMapper;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chapter")
public class ChapterController {

    private final ChapterService chapterService;
    private final ChapterMapper chapterMapper;

    public ChapterController(ChapterService chapterService, ChapterMapper chapterMapper) {
        this.chapterService = chapterService;
        this.chapterMapper = chapterMapper;
    }

    @GetMapping
    public List<ChapterDTO> allChapters() {
        return chapterMapper.toChapterDTOs(chapterService.findAllChapter());
    }

    @GetMapping("/{id}")
    public ChapterDTO getChapter(@PathVariable Long id) {
        return chapterMapper.toChapterDTO(chapterService.findChapter(id));
    }

    @PostMapping("/{id}")
    public void saveChapter(@RequestBody ChapterDTO chapterDTO, @PathVariable Long id) {
        if (chapterDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        chapterService.saveChapter(chapterMapper.toChapter(chapterDTO), id);
    }

    @PutMapping("/{id}")
    public void updateChapter(@RequestBody ChapterDTO chapterDTO, @PathVariable Long id) {
        if (chapterDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }

        chapterService.saveChapter(chapterMapper.toChapter(chapterDTO), id);
    }

    @DeleteMapping("/{id}")
    public void deleteChapter(@PathVariable Long id) {
        chapterService.deleteChapter(id);
    }
}
