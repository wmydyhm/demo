package com.example.demo.test.service;

import com.example.demo.test.entity.User;

import java.util.List;

public interface UserService {
   public List<User> findAll(String name);

}
