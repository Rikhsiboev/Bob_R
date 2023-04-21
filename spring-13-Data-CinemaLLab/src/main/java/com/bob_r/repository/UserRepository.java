package com.bob_r.repository;

import com.bob_r.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    @Override
    List<User> findAll();


    //Write a derived query to read a user with a username?

    @Override
    Optional<User> findById(Long aLong);


    //Write a derived query to list all users that contain a specific name?
    Optional<User> findByUsernameContaining(String name);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    Optional<User> findByUsernameContainingIgnoreCase(String name);

    //Write a derived query to list all users with an age greater than a specified age?
    List<User> findAllByAccountGreaterThanEqual(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email=?1")
    List<User> userEmail(@Param("Email")String email);
    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    List<User> username(@Param("username")String username);
    //Write a JPQL query that returns all users?
    @Query("select u from User u where u=?1")
    List<User> users(@Param("users")String users);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?\
    @Query("select u from User u WHERE u.account.name ILIKE concat('%',?1,'%')")
    List<User> Name(@Param("users")String users);
    //Write a native query that returns all users?
    @Query("select u from User u WHERE u.username=?1")
    List<User> users1(@Param("users")String users);
    //Write a native query that returns all users in the range of ages?
    @Query("select u from User u WHERE u.account.age between ?1 and ?2")
    List<User> users1(@Param("age1")Integer user1,@Param("age2")Integer user2);

    //Write a native query to read a user by email?
    @Query("select u from User u WHERE u.email =?1")
    List<User> email(@Param("email")String email);

}
