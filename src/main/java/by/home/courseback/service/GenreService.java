package by.home.courseback.service;

import by.home.courseback.model.Genre;
import by.home.courseback.repository.GenreRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre findGenre(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }
}
