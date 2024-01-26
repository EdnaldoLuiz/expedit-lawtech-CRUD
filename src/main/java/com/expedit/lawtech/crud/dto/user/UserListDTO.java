package com.expedit.lawtech.crud.dto.user;

import com.expedit.lawtech.crud.model.User;

public record UserListDTO(
    String name,
    String cpf,
    String login
) {
    public UserListDTO(User user) {
        this(user.getName(), user.getCpf(), user.getLogin());
    }
}
