package com.example.demo.test.service;

import com.example.demo.test.entity.User;
import com.example.demo.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


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

    @Override
    public List<String> testColl() {
        List<User> list = userRepository.findAll();
        List<String> li = list.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println("li 循环开始");
        for (int i = 0; i < li.size(); i++) {
            System.out.println(i);
        }
        System.out.println("li 循环结束");
        Map<String, User> map = list.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        System.out.println("map 循环开始");
        for (String id: map.keySet()) {
            System.out.println(id);
            System.out.println("map get i :" + map.get(id));
        }
        System.out.println("map 循环结束");
        return li;
    }
}
