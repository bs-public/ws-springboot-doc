package com;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/v1")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  @Operation(summary = "Create a new user", description = "To create a new user in the system.")
  public UserDTO createUser(@Parameter(
      description = "User object to store in database table") @RequestBody UserDTO userDto) {
    return userService.createUser(userDto);
  }

  @GetMapping("/users")
  @Operation(summary = "Get all available users",
      description = "Retrieves a list of all users in the system.")
  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/users/{id}")
  @Operation(summary = "Get a user by Id",
      description = "Fetches a user based on the provided user ID.")
  public UserDTO getUserById(
      @Parameter(description = "ID of user to return") @PathVariable Integer id) {
    return userService.getUserById(id);
  }

  @PutMapping("/users/{id}")
  @Operation(summary = "Update a user", description = "Updates the details of an existing user.")
  public UserDTO updateUser(
      @Parameter(description = "ID of the user to update") @PathVariable Integer id,
      @Parameter(description = "Updated user object") @RequestBody UserDTO userDetails) {
    return userService.updateUser(id, userDetails);
  }

  @DeleteMapping("/users/{id}")
  @Operation(summary = "Delete a user",
      description = "Deletes a user from the system based on the provided user ID.")
  public void deleteUser(
      @Parameter(description = "ID of the user to delete") @PathVariable Integer id) {
    userService.deleteUser(id);
  }

}

