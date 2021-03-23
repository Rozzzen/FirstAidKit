package com.zhuk.service;

import com.zhuk.domain.user.User;
import com.zhuk.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(@Qualifier("fakeuserdb") UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> findAllUser() {
        return userRepo.findAllUser();
    }

    public Optional<User> findUserById(Long id) {
        return userRepo.findUserById(id);
    }

    public int deleteUserById(Long id) {
        return userRepo.deleteUserById(id);
    }

    public int updateAidKitById(Long id, User user) {
        return userRepo.updateUserById(id, user);
    }

    public void saveUser(User user) {
        userRepo.saveUser(user);
    }

    public void saveUser(User user, Long id) {
        userRepo.saveUser(user, id);
    }
}
