package com.zhuk.service;

import com.zhuk.domain.Role;
import com.zhuk.exception.exceptions.OrderNotFoundException;
import com.zhuk.exception.exceptions.RoleNotFoundException;
import com.zhuk.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepo roleRepo;

    public Role findFirstById(Long id) {
        return roleRepo.findById(id).orElseThrow(() -> new RoleNotFoundException("Failed to find role with id:" + id));
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void update(Long id, Role role) {
        roleRepo.findById(id).orElseThrow(() -> new RoleNotFoundException("Failed to find role with id:" + id));
        role.setId(id);
        roleRepo.save(role);
    }

    public void delete(Long id) {
        roleRepo.findById(id).orElseThrow(() -> new RoleNotFoundException("Failed to find role with id:" + id));
        roleRepo.deleteById(id);
    }
}
