package by.home.courseback.controller;

import by.home.courseback.exeption.CreatedEntityIdException;
import by.home.courseback.exeption.UpdatedEntityIdException;
import by.home.courseback.model.Composition;
import by.home.courseback.service.CompositionService;
import by.home.courseback.service.dto.CompositionDTO;
import by.home.courseback.service.mapper.CompositionMapper;
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
@RequestMapping("/api/composition")
public class CompositionController {

    private final CompositionService compositionService;
    private final CompositionMapper compositionMapper;

    public CompositionController(CompositionService compositionService, CompositionMapper compositionMapper) {
        this.compositionService = compositionService;
        this.compositionMapper = compositionMapper;
    }

    @GetMapping
    public List<CompositionDTO> allCompositions() {
        return compositionMapper.toCompositionDTOs(compositionService.findAllCompositions());
    }

    @GetMapping("/user")
    public List<CompositionDTO> allCompositionsUser() {
        return compositionMapper.toCompositionDTOs(compositionService.findAllCompositionUser());
    }

    @GetMapping("/{id}")
    public CompositionDTO getComposition(@PathVariable Long id) {
        return compositionMapper.toCompositionDTO(compositionService.findComposition(id));
    }

    @PostMapping
    public void saveComposition(@RequestBody CompositionDTO compositionDTO) {
        if (compositionDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        compositionService.saveComposition(compositionMapper.toComposition(compositionDTO));
    }

    @PutMapping
    public void updateComposition(@RequestBody CompositionDTO compositionDTO) {
        if (compositionDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        compositionService.saveComposition(compositionMapper.toComposition(compositionDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteComposition(@PathVariable Long id) {
        compositionService.deleteComposition(id);
    }
}
