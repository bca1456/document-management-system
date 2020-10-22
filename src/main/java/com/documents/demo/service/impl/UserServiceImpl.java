package com.documents.demo.service.impl;

import com.documents.demo.domain.Role;
import com.documents.demo.domain.User;
import com.documents.demo.repos.RoleRepository;
import com.documents.demo.repos.UserRepository;
import com.documents.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
       return userRepository.findById(id).orElse(new User());
    }

    @Override
    public boolean addNew(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null){
            return false;
        }

        user.setRoles(Collections.singleton(new Role("ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    public User findByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
