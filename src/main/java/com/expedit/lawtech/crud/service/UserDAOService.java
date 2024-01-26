package com.expedit.lawtech.crud.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.expedit.lawtech.crud.dto.user.UserListDTO;
import com.expedit.lawtech.crud.dto.user.UserRegisterDTO;
import com.expedit.lawtech.crud.dto.user.UserUpdateDTO;
import com.expedit.lawtech.crud.exception.UserNotFoundException;
import com.expedit.lawtech.crud.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDAOService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createUser(UserRegisterDTO userRegister) {
        User user = new User(userRegister);
        entityManager.persist(user);
    }

    public List<UserListDTO> getAllUsers() {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        List<User> users = query.getResultList();
        return users.stream().map(UserListDTO::new).collect(Collectors.toList());
    }

    public UserListDTO getUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new RuntimeException("Usuario com id " + id + " não encontrado");
        }
        return new UserListDTO(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new UserNotFoundException("Usuário com id " + id + " não encontrado");
        }
        entityManager.remove(user);
    }

    @Transactional
    public void updateUser(UserUpdateDTO dto) {
        User user = entityManager.find(User.class, dto.id());
        if (user == null) {
            throw new UserNotFoundException("Usuário não encontrado");
        }

        user.setName(dto.name());
        user.setLogin(dto.login());
        user.setPassword(dto.password());

        entityManager.merge(user);
    }
}