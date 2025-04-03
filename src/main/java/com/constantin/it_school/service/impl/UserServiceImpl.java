package com.constantin.it_school.service.impl;

import com.constantin.it_school.entity.User;
import com.constantin.it_school.model.UserDTO;
import com.constantin.it_school.repository.UserRepository;
import com.constantin.it_school.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO getUserById(Long id) {
        User foundUser = userRepository.findById(id)
                .orElseThrow();
        return convertUserToDTO(foundUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream().map(this::convertUserToDTO)
                .toList();
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = convertToUser(userDTO);
        User createUser = userRepository.save(user);
        return convertUserToDTO(createUser);
    }

    @Override
    public UserDTO updateUser(long id, UserDTO userDTO) {
        User user = convertToUser(userDTO);
        user.setId(id);
        User updateUser = userRepository.save(user);
        return convertUserToDTO(updateUser);
    }

    @Override
    public UserDTO deleteUser(Long id) {
        userRepository.deleteById(id);
        return null;
    }
    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getAge());
    }
    private User convertToUser(UserDTO userDTO) {
        return new User(userDTO.name(), userDTO.email(), userDTO.age());
    }
}
