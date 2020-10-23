package com.documents.demo.service;


import com.documents.demo.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(int id);
    boolean addNew(User user);
    boolean deleteById(int id);
    boolean update(User user);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
