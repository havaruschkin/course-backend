package by.home.courseback.controller;

import by.home.courseback.exeption.AccountResourceException;
import by.home.courseback.exeption.InvalidPasswordException;
import by.home.courseback.model.User;
import by.home.courseback.service.MailService;
import by.home.courseback.service.UserService;
import by.home.courseback.service.dto.ChapterDTO;
import by.home.courseback.service.dto.UserDTO;
import by.home.courseback.service.mapper.UserMapper;
import by.home.courseback.service.vm.UserVM;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountResourceController {

    private final UserService userService;
    private final MailService mailService;
    private final UserMapper userMapper;

    public AccountResourceController(UserService userService, MailService mailService, UserMapper userMapper) {
        this.userService = userService;
        this.mailService = mailService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@RequestBody UserVM userVM) {
        if (!checkPasswordLength(userVM.getPassword())) {
            throw new InvalidPasswordException();
        }
        User user = userService.registrationUser(userVM, userVM.getPassword());
        mailService.sendActivationEmail(user);
    }

    @GetMapping("/activate")
    public void activateAccount(@RequestParam String key) {
        Optional<User> user = userService.activateRegistration(key);
        if (!user.isPresent()) {
            throw new AccountResourceException();
        }
    }

    @GetMapping("/users")
    public List<UserDTO> allUsers() {
        return userMapper.toUserDTOs(userService.findAllUsers());
    }

    @GetMapping("/users/user/{username}")
    public UserDTO getUser(@PathVariable String username) {
        return userMapper.toUserDTO(userService.findCurrentUser(username));
    }

    @PostMapping("/users/lock")
    public void lock(@RequestBody List<Long> userIds) {
        userService.lockUsers(userIds);
    }

    @PostMapping("/users/unlock")
    public void unlock(@RequestBody List<Long> userIds) {
        userService.unlockUsers(userIds);
    }

    @PostMapping("/users/delete")
    public void delete(@RequestBody List<Long> userIds) {
        userService.deleteUsers(userIds);
    }

    @PostMapping("/users/updateUser")
    public void addAuthority(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    private static boolean checkPasswordLength(String password) {
        return !StringUtils.isEmpty(password) &&
                password.length() >= UserVM.PASSWORD_MIN_LENGTH &&
                password.length() <= UserVM.PASSWORD_MAX_LENGTH;
    }
}
