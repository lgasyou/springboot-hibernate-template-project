package com.xenonwebsite.dao;

import com.xenonwebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByUsername(String username);

}
