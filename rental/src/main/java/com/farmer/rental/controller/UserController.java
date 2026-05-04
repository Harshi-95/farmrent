package com.farmer.rental.controller;

import com.farmer.rental.entity.User;
import com.farmer.rental.repository.UserRepository;
import com.farmer.rental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    // REGISTER
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userService.register(user);
        return "User Registered Successfully";
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null &&
                existingUser.getPassword().equals(user.getPassword())) {

            return existingUser;
        } else {
            return null;
        }
    }
}