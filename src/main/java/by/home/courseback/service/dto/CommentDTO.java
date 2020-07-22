package by.home.courseback.service.dto;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CommentDTO {

    private Long id;
    private String text;
    private String authorUrl;
    private String avatarUrl;
    private String fullName;
    private Date createdAt;
}
