package com.expedit.lawtech.crud.dto.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AdminRegisterDTO(
    
@NotBlank
String name, 

@NotBlank
@Email
String login, 

@NotBlank
String password) {
    
}
