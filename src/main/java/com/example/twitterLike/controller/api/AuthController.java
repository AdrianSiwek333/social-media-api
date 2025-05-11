package com.example.twitterLike.controller.api;

import com.example.twitterLike.model.Users;
import com.example.twitterLike.repository.UsersRepository;
import com.example.twitterLike.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody Users user) {
        String login = user.getUsername();
        String username;

        if(login.contains("@")) {
            username = usersRepository.findByEmail(login).get().getUsername();
        } else {
            username = login;
        }

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        user.getPassword()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    @PostMapping("/signup")
    public String registerUser(@RequestBody Users user) {
        if (usersRepository.existsByUsername(user.getUsername())) {
            return "Error: Username is already taken!";
        }

        Users newUser = new Users(
                null,
                user.getUsername(),
                passwordEncoder.encode(user.getPassword()),
                user.getEmail()
        );
        usersRepository.save(newUser);
        return "User registered successfully!";
    }
}
