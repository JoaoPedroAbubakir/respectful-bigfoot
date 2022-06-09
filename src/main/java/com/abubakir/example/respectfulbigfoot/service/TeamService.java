package com.abubakir.example.respectfulbigfoot.service;

import com.abubakir.example.respectfulbigfoot.entities.Team;
import com.abubakir.example.respectfulbigfoot.exception.NoEntityFoundException;
import com.abubakir.example.respectfulbigfoot.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    TeamRepository teamRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team getTeam(String id) {
        return teamRepository.findById(id).orElse(null);
    }

    public Team updateTeam(Team team) {
        return teamRepository.findById(team.getId()).map(this::createTeam).orElseThrow(() -> new NoEntityFoundException("Could not find team"));
    }

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public boolean deleteTeam(String id) {
        teamRepository.delete(this.getTeam(id));
        return this.getTeam(id) == null;
    }

}
