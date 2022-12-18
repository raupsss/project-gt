package com.example.backend_ektp.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.backend_ektp.model.User;
import com.example.backend_ektp.repository.IUserRepo;

@Repository
public class UserRepo implements IUserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User addUser(User user) {

        String query = "INSERT INTO tb_user(email, nama, password)" + "VALUES(?, ?, ?)";

        jdbcTemplate.update(query, new Object[] {
                user.getEmail(), user.getNama(), user.getPassword()
        });

        return user;
    }

    @Override
    public List<User> getAllUser() {

        String query = "SELECT * FROM tb_user";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User updateUser(int id, User user) {

        String query = "UPDATE tb_user SET email = ?, nama = ?, password = ? WHERE id = ?";

        jdbcTemplate.update(query, new Object[] {
                user.getEmail(), user.getNama(), user.getPassword(), id
        });
        return user;
    }

    @Override
    public User deleteUser(int id) {

        String query = "SELECT * FROM tb_user WHERE id = ?";

        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class));

        query = "DELETE FROM tb_user WHERE id = ?";
        jdbcTemplate.update(query, id);

        return result;
    }

    @Override
    public User getUser(int id) {

        String query = "SELECT * FROM tb_user WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public User login(User user) {
        
        String query = "SELECT * From tb_user WHERE email = ? AND password = ?";
        var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(User.class), new Object[]{
            user.getEmail(), user.getPassword()
        });
        return result;
    }

}
