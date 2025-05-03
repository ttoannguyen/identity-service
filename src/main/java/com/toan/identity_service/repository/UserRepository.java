package com.toan.identity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toan.identity_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByUsername(String username);
}
