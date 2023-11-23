package SkillBox.com.users.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import SkillBox.com.users.entity.User;
import SkillBox.com.users.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(User user) {
        User saved = userRepository.save(user);

        return saved.toString();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String updateUser(User user, long id) {
        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.save(user);

        return "Success";
    }

    public String deleteUser(long id) {

        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        userRepository.deleteById(id);


        return "Success";
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
