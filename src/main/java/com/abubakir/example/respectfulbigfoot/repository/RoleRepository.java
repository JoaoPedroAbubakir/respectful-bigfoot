package com.abubakir.example.respectfulbigfoot.repository;

import com.abubakir.example.respectfulbigfoot.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
