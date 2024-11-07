package com.devsione.enigmate.controller;
import com.devsione.enigmate.model.User;
import com.devsione.enigmate.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = {"http://localhost:5173", "https://enigmate-7h4b.onrender.com", "https://enigmate.quest"})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    List<User> findAll() {
        return (List<User>) userService.findAll();
    }

    @GetMapping("/{id}")
    Optional<User> findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    void registerUser(@Valid @RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        userService.delete(id);
    }






}
