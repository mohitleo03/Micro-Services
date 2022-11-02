package org.ncu.hirewheels.repository;

import java.util.Optional;

import org.ncu.hirewheels.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where r.role_id = ?1")
    public Optional<Role> getRoleById(Integer role_id);
}
