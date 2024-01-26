package com.expedit.lawtech.crud.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expedit.lawtech.crud.dto.user.UserListDTO;
import com.expedit.lawtech.crud.dto.user.UserRegisterDTO;
import com.expedit.lawtech.crud.dto.user.UserUpdateDTO;
import com.expedit.lawtech.crud.service.UserREPOService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/user/repo")
@RequiredArgsConstructor
public class UserREPOController {

    private final UserREPOService service;

    @GetMapping("/getAll")
    public ResponseEntity<Page<UserListDTO>> getAllUsers(
            @PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
        return ResponseEntity.ok().body(service.getAllUsers(pageable));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserListDTO> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.getUser(id));
    }

    @PostMapping("/create")
    @Transactional
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
    @Transactional
    public ResponseEntity<String> updateUser(@RequestBody @Valid UserUpdateDTO dto) {
        service.updateUser(dto);
        return ResponseEntity.ok("Usuário atualizado com sucesso!");
    }
}
