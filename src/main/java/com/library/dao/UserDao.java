package main.java.com.library.dao;

import main.java.com.library.models.User;

import java.util.List;

public interface UserDao {
    User addUser(User user);
    User updateUser(User user);
    void deleteUser(long id);
    User getUserbyId(long id);
}
