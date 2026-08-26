package com.tangerinedemo.springdemoproject.service;

import com.tangerinedemo.springdemoproject.domain.Users;
import com.tangerinedemo.springdemoproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}
