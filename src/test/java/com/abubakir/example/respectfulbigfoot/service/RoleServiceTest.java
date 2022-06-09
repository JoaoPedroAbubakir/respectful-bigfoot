package com.abubakir.example.respectfulbigfoot.service;

import com.abubakir.example.respectfulbigfoot.entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    void createRole() {
        assertNotNull(roleService.createRole(Role.builder().roleName("test-role-name").build()));
        assertTrue(roleService.deleteRole(roleService.getRoleByName("test-role-name").getId()));
    }

    @Test
    void getRole() {
        Role createdRole = roleService.createRole(Role.builder().roleName("test-role-name").build());
        assertNotNull(createdRole);
        Role roleByName = roleService.getRoleByName(createdRole.getRoleName());
        assertNotNull(roleByName);
        assertEquals(createdRole.getRoleName(), roleByName.getRoleName());
        assertEquals(createdRole.getId(), roleByName.getId());
        Role roleById = roleService.getRole(createdRole.getId());
        assertNotNull(roleById);
        assertEquals(createdRole.getRoleName(), roleById.getRoleName());
        assertEquals(createdRole.getId(), roleById.getId());
        assertTrue(roleService.deleteRole(roleService.getRoleByName("test-role-name").getId()));
    }

    @Test
    void updateUser() {
        Role createdRole = roleService.createRole(Role.builder().roleName("test-role-name").build());
        Role roleById = roleService.getRole(createdRole.getId());
        assertNotNull(roleById);
        assertEquals(createdRole.getRoleName(), roleById.getRoleName());
        assertEquals(createdRole.getId(), roleById.getId());
        roleById.setRoleName("test-role-name-updated");
        Role updatedRole = roleService.updateRole(roleById);
        roleService.getRole(updatedRole.getId());
        assertEquals("test-role-name-updated", updatedRole.getRoleName());
        assertEquals(createdRole.getId(), roleById.getId());
        assertTrue(roleService.deleteRole(createdRole.getId()));
    }

    @Test
    void getRoles() {
        List<Role> roles = roleService.getRoles();
        assertNotNull(roles);
    }

    @Test
    void deleteRole() {
        assertTrue(roleService.deleteRole(roleService.getRoleByName("test-role-name").getId()));
    }
}