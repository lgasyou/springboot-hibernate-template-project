package com.xenon.entrance.dao;

import com.xenon.entrance.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, String> {

    User findUserByUsername(String name);

    List<User> findAll();

}
