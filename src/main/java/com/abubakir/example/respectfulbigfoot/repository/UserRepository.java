package com.abubakir.example.respectfulbigfoot.repository;

import com.abubakir.example.respectfulbigfoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
