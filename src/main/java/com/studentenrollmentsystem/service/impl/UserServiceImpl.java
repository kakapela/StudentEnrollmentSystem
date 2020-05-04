package com.studentenrollmentsystem.service.impl;

import com.studentenrollmentsystem.model.User;
import com.studentenrollmentsystem.repository.UserRepository;
import com.studentenrollmentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private  UserRepository userRepository;

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        user.setPassword(getEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }


}
