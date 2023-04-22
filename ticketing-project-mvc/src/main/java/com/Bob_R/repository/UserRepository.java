package com.Bob_R.repository;

import com.Bob_R.entity.Role;
import com.Bob_R.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository  extends JpaRepository<User,Long> {

    User findByUserName(String username);

}
