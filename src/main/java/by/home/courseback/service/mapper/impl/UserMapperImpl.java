package by.home.courseback.service.mapper.impl;

import by.home.courseback.model.Authority;
import by.home.courseback.model.User;
import by.home.courseback.service.dto.UserDTO;
import by.home.courseback.service.mapper.UserMapper;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserMapperImpl implements UserMapper {

    public List<UserDTO> toUserDTOs(List<User> users) {
        return users.stream()
                .filter(Objects::nonNull)
                .map(this::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setLogin(user.getLogin());
        userDTO.setEmail(user.getEmail());
        userDTO.setActivated(user.isActivated());
        userDTO.setCreatedTs(user.getCreatedAt());
        userDTO.setStatus(user.getStatus());
        userDTO.setLanguage(user.getLanguage());
        userDTO.setTheme(user.getTheme());
        userDTO.setAuthorities(user.getAuthorities()
                .stream()
                .map(Authority::getName)
                .collect(Collectors.toSet()));
        return userDTO;
    }

    public User toUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setEmail(userDTO.getEmail());
            user.setActivated(userDTO.isActivated());
            user.setStatus(userDTO.getStatus());
            user.setLanguage(userDTO.getLanguage());
            user.setTheme(userDTO.getTheme());
            Set<Authority> authorities = this.authoritiesFromStrings(userDTO.getAuthorities());
            user.setAuthorities(authorities);
            return user;
        }
    }

    private Set<Authority> authoritiesFromStrings(Set<String> authoritiesAsString) {
        Set<Authority> authorities = new HashSet<>();
        if (authoritiesAsString != null) {
            authorities = authoritiesAsString.stream().map(string -> {
                Authority auth = new Authority();
                auth.setName(string);
                return auth;
            }).collect(Collectors.toSet());
        }
        return authorities;
    }
}
