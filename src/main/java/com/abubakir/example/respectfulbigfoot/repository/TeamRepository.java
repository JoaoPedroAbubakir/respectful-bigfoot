package com.abubakir.example.respectfulbigfoot.repository;

import com.abubakir.example.respectfulbigfoot.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
