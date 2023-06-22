package main.service;

import lombok.RequiredArgsConstructor;
import main.UserPostDto.UserPostDto;
import main.models.User;
import main.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User addUser(UserPostDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
//        user.setRoles(dto.getRole());
//        user.setPassword(dto.getPassword());
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
//        user.setRoles(dto.getRole());
//        user.setPassword(dto.getPassword());
        return userRepository.save(user);
    }
}
