package SkillBox.com.users.controller;

import org.springframework.web.bind.annotation.*;
import SkillBox.com.users.entity.User;
import SkillBox.com.users.service.UserService;

import java.util.List;

@RestController()
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    String createUser(User user) {
        return userService.createUser(user);
    }

    @GetMapping(path = "/{id}")
    User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    String updateUser(@RequestBody User user, @PathVariable long id) {
        return  userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/")
    List<User> getUsers() {
        return userService.getUsers();
    }
}
