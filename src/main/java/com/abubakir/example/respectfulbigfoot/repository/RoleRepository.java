package com.abubakir.example.respectfulbigfoot.repository;

import com.abubakir.example.respectfulbigfoot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role getRoleByName(String roleName);

}
