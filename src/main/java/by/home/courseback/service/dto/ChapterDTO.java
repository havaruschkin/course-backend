package by.home.courseback.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ChapterDTO {

    private Long id;
    private String chapterName;
    private String text;
}
