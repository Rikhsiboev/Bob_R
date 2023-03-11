package com.Bob_R.service;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID> {

  //this method come for all
    T save(T user);
    T findBYID(ID username);
    List<T> findAll();
    void deleteById(ID username);

}
