package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> findAll(String name);
    List<User> listPage(String name, Pageable pageable);
    List<String> testColl();

}
