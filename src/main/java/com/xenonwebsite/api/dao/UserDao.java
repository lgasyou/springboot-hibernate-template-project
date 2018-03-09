package com.xenonwebsite.api.dao;

import com.xenonwebsite.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

    User findUserById(Long id);

}
