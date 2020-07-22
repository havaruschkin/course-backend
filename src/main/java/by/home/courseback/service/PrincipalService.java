package by.home.courseback.service;

import by.home.courseback.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrincipalService {

    private final UserService userService;

    public PrincipalService(UserService userService) {
        this.userService = userService;
    }

    public User getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        return userService.findUserByLogin(principal.getUsername()).orElseThrow(IllegalArgumentException::new);
    }
}
