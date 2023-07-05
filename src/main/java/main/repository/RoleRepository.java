package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
