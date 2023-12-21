package com;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDTO createUser(UserDTO userDto) {
    User user = UserMapper.toEntity(userDto);
    return UserMapper.toDto(userRepository.save(user));
  }

  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
  }

  public UserDTO getUserById(Integer id) {
    return userRepository.findById(id).map(UserMapper::toDto).orElse(null);
  }

  public UserDTO updateUser(Integer id, UserDTO userDetailsDto) {
    return userRepository.findById(id).map(user -> {
      user.setName(userDetailsDto.getName());
      user.setEmail(userDetailsDto.getEmail());
      return UserMapper.toDto(userRepository.save(user));
    }).orElse(null);
  }

  public void deleteUser(Integer id) {
    userRepository.deleteById(id);
  }

}
