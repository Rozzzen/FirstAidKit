package com.zhuk.repo;

import com.zhuk.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeuserdb")
public class FakeUserDataAcess implements UserRepo {

    Long counter = 4L;
    private final List<User> users = new ArrayList<>();

    public FakeUserDataAcess() {
        users.add(new User(1L, "John", null, null, null, null, null, null, null));
        users.add(new User(2L, "Mark", null, null, null, null, null, null, null));
        users.add(new User(3L, "Steve", null, null, null, null, null, null, null));
        users.add(new User(4L, "Jake", null, null, null, null, null, null, null));
    }

    @Override
    public List<User> findAllUser() {
        return users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return users.stream().
                filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteUserById(Long id) {
        Optional<User> userMaybe = findUserById(id);
        if(!userMaybe.isPresent()) return 0;
        users.remove(userMaybe.get());
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

    @Override
    public void saveUser(User user) {
        user.setId(++counter);
        users.add(user);
    }

    @Override
    public void saveUser(User user, Long id) {
        user.setId(id);
        users.add(user);
    }
}
