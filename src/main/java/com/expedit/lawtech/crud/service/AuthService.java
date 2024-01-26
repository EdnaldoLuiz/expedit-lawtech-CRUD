package com.expedit.lawtech.crud.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expedit.lawtech.crud.dto.admin.AdminLoginDTO;
import com.expedit.lawtech.crud.dto.admin.AdminRegisterDTO;
import com.expedit.lawtech.crud.dto.jwt.TokenDTO;
import com.expedit.lawtech.crud.model.Admin;
import com.expedit.lawtech.crud.repository.AdminRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AdminRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Transactional
    public Admin register(@Valid AdminRegisterDTO dto) {
        var admin = new Admin(dto);
        admin.setPassword(passwordEncoder.encode(dto.password()));
        repository.save(admin);
        return admin;
    }

    @Transactional
    public TokenDTO login(@Valid AdminLoginDTO dto) {
        var admin = (Admin) repository.findByLogin(dto.login());
        if (admin != null && passwordEncoder.matches(dto.password(), admin.getPassword())) {
            var tokenJWT = tokenService.gerarToken(admin);
            return new TokenDTO(tokenJWT);
        }
        return null;
    }
}