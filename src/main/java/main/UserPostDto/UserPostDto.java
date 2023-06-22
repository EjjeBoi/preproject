package main.UserPostDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDto {
    private String firstName;

    private String lastName;

    private String email;

    private String userName;

//    private Set<Role> role;
}
