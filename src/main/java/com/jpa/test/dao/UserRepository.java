package com.jpa.test.dao;

import com.jpa.test.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findByName(String name);

    public List<User> findByNameAndCity(String name,String city);

    @Query("select u from User u")
    public List<User> getByAllUser();

    @Query("select u from User u where u.name=:n and u.city=:m")
    public List<User> getByNameAndCity(@Param("n") String name,@Param("m") String city);

    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getAllUsers();
}