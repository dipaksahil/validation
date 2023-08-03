package com.validation.service;

import com.validation.entity.UserEntity;
import com.validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }
}

