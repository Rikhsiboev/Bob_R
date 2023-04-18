package com.Bob_R.repository;

import com.Bob_R.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findByDescription(String description);


}
