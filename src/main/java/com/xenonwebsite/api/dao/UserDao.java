package com.xenonwebsite.api.dao;

import com.xenonwebsite.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User findUserByUsername(String name);

    List<User> findAll();

}
