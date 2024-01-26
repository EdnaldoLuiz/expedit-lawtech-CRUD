package com.expedit.lawtech.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expedit.lawtech.crud.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
    Admin findByLogin(String login);

}
