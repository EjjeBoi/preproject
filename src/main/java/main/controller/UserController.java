package main.controller;

import lombok.RequiredArgsConstructor;
import main.dto.UserPostDto;
import main.models.User;
import main.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User addUser(@RequestBody UserPostDto dto) {
        return userService.addUser(dto);
    }

    @DeleteMapping("delete")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUsers() {
        userService.deleteAll();
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping("update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User updateUserById(@PathVariable Long id, @RequestBody UserPostDto dto) {
        return userService.updateUserById(id, dto);
    }
    @GetMapping("user")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/assign-role")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void assignRoleToUser(@RequestParam Long userId, @RequestParam Long roleId) {
        userService.assignRoleToUser(userId, roleId);
    }
}
