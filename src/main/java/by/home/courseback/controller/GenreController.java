package by.home.courseback.controller;

import by.home.courseback.service.GenreService;
import by.home.courseback.service.dto.GenreDTO;
import by.home.courseback.service.mapper.GenreMapper;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenreController {

    private final GenreService genreService;
    private final GenreMapper genreMapper;

    public GenreController(GenreService genreService, GenreMapper genreMapper) {
        this.genreService = genreService;
        this.genreMapper = genreMapper;
    }

    @GetMapping("/genre")
    public List<GenreDTO> allGenres() {
        return genreMapper.toGenreDTOs(genreService.findAllGenres());
    }

}
