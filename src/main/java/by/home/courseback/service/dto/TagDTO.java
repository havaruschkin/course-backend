package by.home.courseback.service.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class TagDTO {

    private Long id;
    private String name;
    private List<CompositionDTO> compositions;
}
