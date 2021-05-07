package com.zhuk.controller;

import com.zhuk.domain.User;
import com.zhuk.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @GetMapping("/")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return userService.findFirstById(id);
    }

    @PostMapping
    public List<User> save(User user) {
        userService.save(user);
        return userService.findAll();
    }

    @PutMapping("{id}")
    public List<User> update(@PathVariable Long id, @RequestBody User user) {
        userService.update(id, user);
        return userService.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
