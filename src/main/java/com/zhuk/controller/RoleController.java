package com.zhuk.controller;

import com.zhuk.domain.Role;
import com.zhuk.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("role")
public class RoleController {

    private RoleService roleService;

    @GetMapping("/")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("{id}")
    public Role findById(@PathVariable Long id) {
        return roleService.findFirstById(id);
    }

    @PostMapping
    public List<Role> save(Role role) {
        roleService.save(role);
        return roleService.findAll();
    }

    @PutMapping("{id}")
    public List<Role> update(@PathVariable Long id, @RequestBody Role role) {
        roleService.update(id, role);
        return roleService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }
}
