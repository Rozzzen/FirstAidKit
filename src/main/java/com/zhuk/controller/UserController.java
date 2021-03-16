package com.zhuk.controller;

import com.zhuk.domain.user.User;
import com.zhuk.exception.FirstAidKitException;
import com.zhuk.service.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserController {
    private UserService userService;

    public void updateUser(Long id, User user) throws FirstAidKitException {
        if(userService.updateAidKitById(id, user) == 0) {
            throw new FirstAidKitException("Failed to update user");
        }
        else {
            System.out.println("All good");
        }
    }

    public void deleteUser(Long id) throws FirstAidKitException {
       if(userService.deleteAidKitById(id) == 0) {
           throw new FirstAidKitException("Failed to delete user");
       }
       else {
           System.out.println("All good");
       }
    }

    public void saveUser(User user) throws FirstAidKitException {
        if(userService.findAllUser().contains(user)) {
            throw new FirstAidKitException("This user already exists");
        }
        else {
            userService.saveUser(user);
            System.out.println("All good");
        }
    }
}
