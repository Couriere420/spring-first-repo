package com.constantin.it_school.controller;

import com.constantin.it_school.model.UserDTO;
import com.constantin.it_school.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Users Management", description = "APIs for managing users in the system")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get user details by ID",description = """
            Retrieves user information\
             based on the provided user ID\
            . Returns a UserDTO object containing user details such as name,email and age.""")
    @GetMapping("{id}")
    public UserDTO findUser(@PathVariable long id) {
        return userService.getUserById(id);
    }
@Operation(summary = "Retrieve all users",description = """
        Fetches a list of all users \
        from the database and returns their details as a list of UserDTO objects.
        
        """)
    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.getAllUsers();
    }
@Operation(summary = "Create a new user",description = """
        Adds a new user to the system and returns\
         the created user details.""")
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);

    }
@Operation(summary = "Update an existing user",description = """
        Updates a user’s details based on the given ID.\
         \
        If the user exists, their information is modified and returned.\
         If the user is not found, an appropriate error response is returned.""")
    @PutMapping("{id}")
    public UserDTO updateUser(@PathVariable long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
@Operation(summary = "Remove a user by ID",description = """
        Removes a user from the system \
        based on the provided user ID. If the user does not exist, \
        an appropriate error response is returned.""")
    @DeleteMapping("{id}")
    public void deleteUSer(@PathVariable long id) {
        userService.deleteUser(id);
    }

}

