package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.*;

public interface IAuthRepository extends JpaRepository<Auth, String>{
    
    @Query(value = "SELECT name FROM auth INNER JOIN role ON auth.id_role=role.id_role WHERE gmail=:gmail", nativeQuery = true)
    public String getRole(@Param("gmail") String gmail ); 
}
