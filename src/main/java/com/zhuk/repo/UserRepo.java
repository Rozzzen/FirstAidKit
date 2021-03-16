package com.zhuk.repo;

import com.zhuk.domain.user.User;

import java.util.List;
import java.util.Optional;

//Will extend JPA Repo
public interface UserRepo {
    List<User> findAllUser();
    Optional<User> findUserById(Long id);
    int deleteUserById(Long id);
    int updateUserById(Long id, User user);
}
