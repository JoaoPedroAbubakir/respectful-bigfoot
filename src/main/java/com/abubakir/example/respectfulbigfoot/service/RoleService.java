package com.abubakir.example.respectfulbigfoot.service;

import com.abubakir.example.respectfulbigfoot.entities.Role;
import com.abubakir.example.respectfulbigfoot.entities.User;
import com.abubakir.example.respectfulbigfoot.exception.NoEntityFoundException;
import com.abubakir.example.respectfulbigfoot.repository.RoleRepository;
import com.abubakir.example.respectfulbigfoot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Role updateUser(Role role) {
        return roleRepository.findById(role.getId()).map(this::createRole).orElseThrow(() -> new NoEntityFoundException("Could not find role"));
    }

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public boolean deleteRole(Long id) {
        roleRepository.delete(this.getRole(id));
        return this.getRole(id) == null;
    }
}
