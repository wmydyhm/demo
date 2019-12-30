package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
   public List<User> findAll(String name);
   public List<User> findAllP(String name, Pageable Pageable);

   List<User> listPage(String name, Pageable pageable);

}
