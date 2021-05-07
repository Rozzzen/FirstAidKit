package com.zhuk.service;

import com.zhuk.domain.User;
import com.zhuk.exception.ElementNotFoundException;
import com.zhuk.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public User findFirstById(Long id) {
        return userRepo.findById(id).orElseThrow(ElementNotFoundException::new);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void update(Long id, User user) {
        userRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        user.setId(id);
        userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.findById(id).orElseThrow(ElementNotFoundException::new);
        userRepo.deleteById(id);
    }
}
