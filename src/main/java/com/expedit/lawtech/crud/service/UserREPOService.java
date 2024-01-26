package com.expedit.lawtech.crud.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.expedit.lawtech.crud.dto.user.UserListDTO;
import com.expedit.lawtech.crud.dto.user.UserRegisterDTO;
import com.expedit.lawtech.crud.dto.user.UserUpdateDTO;
import com.expedit.lawtech.crud.exception.UserNotFoundException;
import com.expedit.lawtech.crud.model.User;
import com.expedit.lawtech.crud.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserREPOService {

    private final UserRepository repository;

    public void createUser(UserRegisterDTO userRegister) {
        User user = new User(userRegister);
        repository.save(user);
    }

    public Page<UserListDTO> getAllUsers(Pageable pageable) {
        return repository.findAll(pageable)
                .map(UserListDTO::new);
    }

    public UserListDTO getUser(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario com id " + id + " não encontrado"));
        return new UserListDTO(user);
    }

    public void deleteUser(Long id) {
        if (!repository.existsById(id)) {
            throw new UserNotFoundException("Usuário com id " + id + " não encontrado");
        }
        repository.deleteById(id);
    }

    public void updateUser(UserUpdateDTO dto) {
        User user = repository.findById(dto.id())
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado"));

        user.setName(dto.name());
        user.setLogin(dto.login());
        user.setPassword(dto.password());

        repository.save(user);
    }
}
