package com.expedit.lawtech.crud.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.expedit.lawtech.crud.dto.admin.AdminRegisterDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "admins")
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String login;
    private String password;

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(() -> "ROLE_ADMIN");
    }

    @Override
    public String getUsername() {
       return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
         return this.password;
    }

    public Admin(@Valid AdminRegisterDTO dto) {
        this.name = dto.name();
        this.login = dto.login();
        this.password = dto.password();
    }
    
}
