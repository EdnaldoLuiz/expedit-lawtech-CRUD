package com.expedit.lawtech.crud.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO (

    @NotNull
    Long id,

    @NotBlank
    String name,

    @NotBlank
    @Email
    String login,

    @NotBlank
    String password
) {}
