package by.home.courseback.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CompositionDTO {

    private Long id;
    private String compositionName;
    private String description;
    private String urlImage;
    private String altImage;
    private GenreDTO genre;
    private Set<TagDTO> tags;
    private List<ChapterDTO> chapters;
    private List<CommentDTO> comments;
    private UserDTO user;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime updatedAt;
}
