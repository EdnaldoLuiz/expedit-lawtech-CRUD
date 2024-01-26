package com.expedit.lawtech.crud.model;

import com.expedit.lawtech.crud.dto.user.UserRegisterDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String login;
    private String password;

    public User(UserRegisterDTO dto) {
        this.name = dto.name();
        this.cpf = dto.cpf();
        this.login = dto.login();
        this.password = dto.password();
    }
}
