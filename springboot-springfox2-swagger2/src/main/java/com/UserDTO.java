package com;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "Data Transfer Object for User information")
@Data
public class UserDTO {

  @ApiModelProperty(readOnly = true, notes = "The auto-generated unique id of the user")
  private Integer id;

  @ApiModelProperty(required = true, notes = "The name of the user")
  private String name;

  @ApiModelProperty(required = true, notes = "The email of the user")
  private String email;

}
