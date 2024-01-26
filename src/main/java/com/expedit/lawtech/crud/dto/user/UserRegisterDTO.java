package com.expedit.lawtech.crud.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegisterDTO (

    @NotBlank
    String name,

    @NotBlank
    @Size(min = 11, max = 11, message = "CPF deve ter exatamente 11 caracteres")
    @Pattern(regexp = "\\d+", message = "CPF deve conter apenas números")
    String cpf,

    @NotBlank
    @Email
    String login,

    @NotBlank
    String password
) {}






