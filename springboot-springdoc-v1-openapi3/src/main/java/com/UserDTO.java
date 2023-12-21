package com;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Data Transfer Object for User information")
@Data
public class UserDTO {

  @Schema(description = "The auto-generated unique id of the user",
      accessMode = Schema.AccessMode.READ_ONLY)
  private Integer id;

  @Schema(description = "The name of the user", required = true)
  private String name;

  @Schema(description = "The email of the user", required = true)
  private String email;

}
