package com.zhuk.service;

import com.zhuk.domain.User;
import com.zhuk.exception.exceptions.UserNotFoundException;
import com.zhuk.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public User findFirstById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Failed to find user with id:" + id));
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void update(Long id, User user) {
        userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Failed to find user with id:" + id));
        user.setId(id);
        userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Failed to find user with id:" + id));
        userRepo.deleteById(id);
    }
}
