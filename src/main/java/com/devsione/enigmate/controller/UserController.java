package com.devsione.enigmate.controller;
import com.devsione.enigmate.model.User;
import com.devsione.enigmate.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("")
    List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> findById(@PathVariable Long id) {
        return userRepository.findById(id);
    }




}
