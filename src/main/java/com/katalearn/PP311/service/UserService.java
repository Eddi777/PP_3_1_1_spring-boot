package com.katalearn.PP311.service;

import com.katalearn.PP311.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);

}
