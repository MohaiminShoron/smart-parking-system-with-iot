package com.seng696.Seng696.service;

import com.seng696.Seng696.entity.User;
import com.seng696.Seng696.exception.UserAuthenticationException;
import com.seng696.Seng696.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(User user) {
        // Check if the email is already registered
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email address already registered");
        }

        // Encrypt the password before saving to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set any other properties or validations as needed

        // Save the user to the database
        userRepository.save(user);
    }

    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new UserAuthenticationException("Invalid email or password");
        }

        return user;
    }
}

