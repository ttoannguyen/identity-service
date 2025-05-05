package com.toan.identity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toan.identity_service.entity.InvalidatedToken;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {

}
