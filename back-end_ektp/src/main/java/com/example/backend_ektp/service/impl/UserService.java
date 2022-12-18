package com.example.backend_ektp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_ektp.model.User;
import com.example.backend_ektp.repository.IUserRepo;
import com.example.backend_ektp.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepo userRepo;

    @Override
    public User addUser(User user) {

        return userRepo.addUser(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepo.getAllUser();
    }

    @Override
    public User updateUser(int id, User user) {

        return userRepo.updateUser(id, user);
    }

    @Override
    public User deleteUser(int id) {

        return userRepo.deleteUser(id);
    }

    @Override
    public User getUser(int id) {

        return userRepo.getUser(id);
    }

    @Override
    public User login(User user) {
        
        return userRepo.login(user);
    }

}
