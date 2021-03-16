package com.zhuk.repo;

import com.zhuk.domain.user.User;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FakeUserDataAcess implements UserRepo{

    private List<User> users;

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return users.stream().
                filter(aidkit -> aidkit.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(Long id) {
        Optional<User> aidKitMaybe = findUserById(id);
        if(!aidKitMaybe.isPresent()) return 0;
        users.remove(aidKitMaybe.get());
        return 1;
    }

    @Override
    public int updateUserById(Long id, User user) {
        return findUserById(id).
                map(u -> {
                    int indexOfAidKitToDelete = users.indexOf(u);
                    if (indexOfAidKitToDelete >= 0) {
                        users.set(indexOfAidKitToDelete, user);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
