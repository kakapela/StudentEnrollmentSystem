package com.studentenrollmentsystem.service;

import com.studentenrollmentsystem.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {


    @Transactional
    User saveUser(User user);

    User findByUsername(String username);

    List<User> findAllUsers();

    @Transactional
    User updateUser(User user);
}
