package com.xenonwebsite.api.dao;

import com.xenonwebsite.api.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, String> {

    User findUserByUsername(String name);

    List<User> findAll();

}
