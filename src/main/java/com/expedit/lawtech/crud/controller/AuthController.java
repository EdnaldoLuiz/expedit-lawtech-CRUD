package com.expedit.lawtech.crud.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.expedit.lawtech.crud.dto.admin.AdminLoginDTO;
import com.expedit.lawtech.crud.dto.admin.AdminRegisterDTO;
import com.expedit.lawtech.crud.model.Admin;
import com.expedit.lawtech.crud.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Admin> register(@RequestBody @Valid AdminRegisterDTO dto) {
        Admin admin = authService.register(dto);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(admin.getId())
                .toUri();
        return ResponseEntity.created(uri).body(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AdminLoginDTO dto) {
        var tokenDTO = authService.login(dto);
        if (tokenDTO != null) {
            return ResponseEntity.ok(tokenDTO);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}