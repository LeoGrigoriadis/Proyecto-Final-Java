package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthRepository extends JpaRepository<Auth, String>{
    
}
