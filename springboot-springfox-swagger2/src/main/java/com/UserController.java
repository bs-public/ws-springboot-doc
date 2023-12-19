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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/v1")
@Api(description = "User Management Controller")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  @ApiOperation(value = "Create a new user", response = UserDTO.class)
  public UserDTO createUser(@ApiParam(value = "User object to store in database table",
      required = true) @RequestBody UserDTO userDto) {
    return userService.createUser(userDto);
  }

  @GetMapping("/users")
  @ApiOperation(value = "Get all available users", response = UserDTO.class,
      responseContainer = "List")
  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/users/{id}")
  @ApiOperation(value = "Get a user by Id", response = UserDTO.class)
  public UserDTO getUserById(
      @ApiParam(value = "ID of user to return", required = true) @PathVariable Integer id) {
    return userService.getUserById(id);
  }

  @PutMapping("/users/{id}")
  @ApiOperation(value = "Update a user", response = UserDTO.class)
  public UserDTO updateUser(
      @ApiParam(value = "ID of the user to update", required = true) @PathVariable Integer id,
      @ApiParam(value = "Updated user object", required = true) @RequestBody UserDTO userDetails) {
    return userService.updateUser(id, userDetails);
  }

  @DeleteMapping("/users/{id}")
  @ApiOperation(value = "Delete a user")
  public void deleteUser(
      @ApiParam(value = "ID of the user to delete", required = true) @PathVariable Integer id) {
    userService.deleteUser(id);
  }
}
