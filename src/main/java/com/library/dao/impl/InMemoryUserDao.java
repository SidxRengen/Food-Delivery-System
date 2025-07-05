package main.java.com.library.dao.impl;

import main.java.com.library.dao.UserDao;
import main.java.com.library.models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserDao implements UserDao {
    private final Map<Long,User> users = new HashMap<>();
    private final AtomicLong ID = new AtomicLong(1);
    @Override
    public User addUser(User user) {
        long UserId = ID.getAndIncrement();
        user.setId(UserId);
        users.put(UserId, user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        if (users.containsKey(user.getId())){
            users.put(user.getId(),user);
            return user;
        }
        return null;
    }

    @Override
    public User getUserbyId(long id) {
        if (users.containsKey(id)){
            return users.get(id);
        }
        return null;
    }

    @Override
    public void deleteUser(long id) {
        if (users.containsKey(id)){
            users.remove(id);
        }
    }
}
