package com.expedit.lawtech.crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.expedit.lawtech.crud.dto.user.UserListDTO;
import com.expedit.lawtech.crud.dto.user.UserRegisterDTO;
import com.expedit.lawtech.crud.dto.user.UserUpdateDTO;
import com.expedit.lawtech.crud.service.UserDAOService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/user/dao")
@RequiredArgsConstructor
public class UserDAOController {

    private final UserDAOService service;

    @GetMapping("/getAll")
    public ResponseEntity<List<UserListDTO>> getAllUsers() {
        return ResponseEntity.ok().body(service.getAllUsers());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserListDTO> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getUser(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserRegisterDTO dto) {
        service.createUser(dto);
        return ResponseEntity.ok("Usuário criado com sucesso!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserUpdateDTO dto) {
        service.updateUser(dto);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }
}