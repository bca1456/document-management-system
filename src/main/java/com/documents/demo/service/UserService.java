package com.documents.demo.service;


import com.documents.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    boolean addNew(User user);
    boolean deleteById(int id);
    boolean update(User user);
    User findByUsername(String name);
}
