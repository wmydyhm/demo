package com.example.demo.test.repository;


import com.example.demo.test.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //    @Query(nativeQuery = true, value = "select distinct * from user a where a.name like concat('%',:na,'%')")
    @Query(nativeQuery = true, value = "select * from User u ")
    List<User> list(@Param("na") String na);
    @Query(nativeQuery = true, value="select * from user u where u.name like :name")
    List<User> listPage(String name, Pageable pageable);

}
