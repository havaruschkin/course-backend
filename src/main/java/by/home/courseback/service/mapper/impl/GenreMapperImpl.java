package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Genre;
import by.home.courseback.service.dto.GenreDTO;
import by.home.courseback.service.mapper.GenreMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class GenreMapperImpl implements GenreMapper {

    @Override
    public List<GenreDTO> toGenreDTOs(List<Genre> genres) {
        return genres.stream()
                .map(this::toGenreDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GenreDTO toGenreDTO(Genre genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setGenreName(genre.getGenreName());
        return genreDTO;
    }

    @Override
    public Genre toGenre(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setId(genreDTO.getId());
        genre.setGenreName(genreDTO.getGenreName());
        return genre;
    }
}
