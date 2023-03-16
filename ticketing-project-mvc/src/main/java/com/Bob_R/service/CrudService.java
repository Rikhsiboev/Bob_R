package com.Bob_R.service;

import com.Bob_R.dto.RoleDTO;
import com.Bob_R.dto.UserDTO;

import java.util.List;

public interface CrudService <T,ID> {

  T save(T user);
  T findById(ID username);
  List<T> findAll();
  void deleteById(ID username);
  void update(T object);




}

