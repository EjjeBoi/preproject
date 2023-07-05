package main.service;

import lombok.RequiredArgsConstructor;
import main.dto.UserPostDto;
import main.models.User;
import main.repository.RoleRepository;
import main.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import main.models.Role;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(UserPostDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setRoles(dto.getRole());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, UserPostDto dto) {
        User user = userRepository.getById(id);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setRoles(dto.getRole());
        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }

    public void assignRoleToUser(Long userId, Long roleId) {
        User user = userRepository.getById(userId);
        Role role = roleRepository.getById(roleId);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.getByUserName(username);
    }
}
