package com.example.MovieReview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // SIGNUP endpoint
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(User.class.getName()) != null) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }

        // Save the new user
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }
}
