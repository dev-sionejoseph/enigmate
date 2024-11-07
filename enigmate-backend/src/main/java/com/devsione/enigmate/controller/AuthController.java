package com.devsione.enigmate.controller;

import com.devsione.enigmate.model.User;
import com.devsione.enigmate.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = {"http://localhost:5173", "https://enigmate-7h4b.onrender.com", "https://enigmate.quest"})
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity<?> login(@RequestBody User userAuth){
        User user = userService.findByUsername(userAuth.getUsername());

        if (user != null && user.getPassword().equals(userAuth.getPassword())) {
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
