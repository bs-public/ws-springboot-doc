package com;

public class UserMapper {

  public static UserDTO toDto(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    return dto;
  }

  public static User toEntity(UserDTO dto) {
    User user = new User();
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    return user;
  }

}
