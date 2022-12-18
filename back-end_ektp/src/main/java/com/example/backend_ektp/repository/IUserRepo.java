package com.example.backend_ektp.repository;

import java.util.List;

import com.example.backend_ektp.model.User;

public interface IUserRepo {

    public User addUser(User user);

    public List<User> getAllUser();

    public User updateUser(int id, User user);

    public User deleteUser(int id);

    public User getUser(int id);

    public User login(User user);

}
