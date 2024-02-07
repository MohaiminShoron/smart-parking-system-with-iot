package com.seng696.Seng696.controller;

import com.seng696.Seng696.entity.User;
import com.seng696.Seng696.exception.UserAuthenticationException;
import com.seng696.Seng696.repository.UserRepository;
import com.seng696.Seng696.security.JwtService;
import com.seng696.Seng696.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * The AuthController class is responsible for handling all authentication-related actions.
 * It provides endpoints for user registration and login.
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Endpoint for user registration.
     * Encrypts the user's password and sends the registration information to the DB.
     *
     * @param user The user data for registration.
     * @return A response message indicating the registration result.
     */


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to register user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Endpoint for user authentication.
     * Verifies the user credentials and generates a JWT token if authentication is successful.
     *
     * @param loginRequest The user login credentials.
     * @return A ResponseEntity containing the user details or an error message.
     */
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@RequestBody User loginRequest) {
//        User user = userRepository.findByFullName(loginRequest.getFullName());
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            String token = jwtService.generateToken(user.getFullName());
//            return ResponseEntity.ok(user
//            );
//        }
//        return ResponseEntity.status(401).body("Invalid credentials");
//    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {
        try {
            userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } catch (UserAuthenticationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
