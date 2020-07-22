package by.home.courseback.service.mapper;

import by.home.courseback.model.Genre;
import by.home.courseback.service.dto.GenreDTO;
import java.util.List;

public interface GenreMapper {

    List<GenreDTO> toGenreDTOs(List<Genre> genres);

    GenreDTO toGenreDTO(Genre genre);

    Genre toGenre(GenreDTO genreDTO);
}
