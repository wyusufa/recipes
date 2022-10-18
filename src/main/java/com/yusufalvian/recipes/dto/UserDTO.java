package com.yusufalvian.recipes.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotBlank
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}",message = "email is invalid")
    private String username; //using email as username

    @NotBlank
    @Size(min = 8, max = 15)
    private String password;

    @NotBlank
    private String role;
}
