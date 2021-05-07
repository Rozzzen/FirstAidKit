package com.zhuk.service;

import com.zhuk.domain.Role;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private RoleRepo roleRepo;

    public Role findFirstById(Long id) {
        return roleRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public void save(Role role) {
        roleRepo.save(role);
    }

    public void update(Long id, Role role) {
        roleRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        role.setId(id);
        roleRepo.save(role);
    }

    public void delete(Long id) {
        roleRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        roleRepo.deleteById(id);
    }
}
