package com.constantin.it_school.service;

import com.constantin.it_school.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(long id,UserDTO userDTO);

    UserDTO deleteUser(Long id);
}
