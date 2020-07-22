package by.home.courseback.service.mapper;

import by.home.courseback.model.User;
import by.home.courseback.service.dto.UserDTO;
import java.util.List;

public interface UserMapper {

    List<UserDTO> toUserDTOs(List<User> users);

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDto);
    }
