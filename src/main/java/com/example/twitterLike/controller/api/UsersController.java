package com.example.twitterLike.controller.api;

import com.example.twitterLike.dto.UserDto;
import com.example.twitterLike.model.Users;
import com.example.twitterLike.dto.UserCreateDto;
import com.example.twitterLike.service.UsersService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return usersService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Long userId) {
        return usersService.findUserById(userId);
    }

    @PostMapping("/add")
    public void addUser(@Valid @RequestBody UserCreateDto userCreateDto) {
        Users user = new Users();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());
        user.setEmail(userCreateDto.getEmail());
        usersService.saveUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        Users user = usersService.findUserEntityById(userId);
        if(!isCurrentUserOwner(user)) {
            throw new IllegalArgumentException("You are not authorized to delete this user");
        }
        usersService.deleteUser(userId);
    }

    // To do: Implement authentication and authorization
    private boolean isCurrentUserOwner(Users user) {
        return true; // Placeholder for actual authentication logic
    }
}
