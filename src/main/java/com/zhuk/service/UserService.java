package com.zhuk.service;

import com.zhuk.domain.user.User;
import com.zhuk.repo.UserRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public List<User> findAllUser() {
        return userRepo.findAllUser();
    }

    public Optional<User> findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public int deleteAidKitById(Long id) {
        return userRepo.deleteUserById(id);
    }

    public int updateAidKitById(Long id, User user) {
        return userRepo.updateUserById(id, user);
    }

    public void saveUser(User user) {
        userRepo.saveUser(user);
    }
}
