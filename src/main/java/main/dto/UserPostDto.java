package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.models.Role;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto {
    private String firstName;

    private String lastName;

    private String email;

    private String userName;

    private Set<Role> role;

    private String password;
}
