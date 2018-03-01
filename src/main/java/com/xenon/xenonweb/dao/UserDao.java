package com.xenon.xenonweb.dao;

import com.xenon.xenonweb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, String> {

    User findUserByUsername(String name);

    List<User> findAll();

}
