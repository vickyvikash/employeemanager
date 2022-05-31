package com.softtechi.employeemanager.dao;

import java.util.Optional;

import com.softtechi.employeemanager.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);
    
}
