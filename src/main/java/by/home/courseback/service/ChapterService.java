package by.home.courseback.service;

import by.home.courseback.model.Chapter;
import by.home.courseback.repository.ChapterRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final CompositionService compositionService;

    public ChapterService(ChapterRepository chapterRepository, CompositionService compositionService) {
        this.chapterRepository = chapterRepository;
        this.compositionService = compositionService;
    }

    public List<Chapter> findAllChapter() {
        return chapterRepository.findAll();
    }

    public void saveChapter(Chapter chapter, Long id) {
        chapter.setComposition(compositionService.findComposition(id));
        chapterRepository.save(chapter);
    }

    public Chapter findChapter(Long id) {
        return chapterRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void deleteChapter(Long idChapter) {
        chapterRepository.deleteById(idChapter);
    }
}
