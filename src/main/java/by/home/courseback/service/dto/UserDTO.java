package by.home.courseback.service.dto;

import by.home.courseback.model.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDTO {

    private Long id;

    @NotBlank
    private String login;

    @Email
    private String email;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdTs;

    private boolean activated = false;
    private Set<String> authorities;
    private Status status;
}
