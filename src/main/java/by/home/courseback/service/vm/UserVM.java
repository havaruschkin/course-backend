package by.home.courseback.service.vm;

import by.home.courseback.service.dto.UserDTO;
import javax.validation.constraints.Size;

public class UserVM extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 1;
    public static final int PASSWORD_MAX_LENGTH = 20;

    @Size(min = PASSWORD_MIN_LENGTH)
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
