package by.home.courseback.service.mapper;

import by.home.courseback.model.Composition;
import by.home.courseback.service.dto.CompositionDTO;
import java.util.Collection;
import java.util.List;

public interface CompositionMapper {

    List<Composition> toCompositions(Collection<CompositionDTO> compositionDTOS);

    List<CompositionDTO> toCompositionDTOs(List<Composition> compositions);

    CompositionDTO toCompositionDTO(Composition composition);

    Composition toComposition(CompositionDTO compositionDTO);
}
