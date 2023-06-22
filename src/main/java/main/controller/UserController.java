package main.controller;

import lombok.RequiredArgsConstructor;
import main.UserPostDto.UserPostDto;
import main.models.User;
import main.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("add")
    public User addUser(@RequestBody UserPostDto dto) {
       return userService.addUser(dto);
    }

    @DeleteMapping("delete")
    public void deleteUsers() {
    userService.deleteAll();
    }

    @PutMapping("update/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody UserPostDto dto) {
        return userService.updateUserById(id, dto);
    }
}
