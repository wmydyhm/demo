package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import com.example.demo.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll(String name) {
        List<User> list = userRepository.list(name);
        return list;

    }

    @Override
    public List<User> listPage(String name, Pageable pageable) {
        name = "%"+ name + "%";
        return userRepository.listPage(name, pageable);
    }
}
