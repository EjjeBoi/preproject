package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Role;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
