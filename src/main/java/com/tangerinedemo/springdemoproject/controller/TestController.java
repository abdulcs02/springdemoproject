package com.tangerinedemo.springdemoproject.controller;

import com.tangerinedemo.springdemoproject.domain.Users;
import com.tangerinedemo.springdemoproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test111")
    public ResponseEntity<List<Users>> test() {
        List<Users> users = testService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
