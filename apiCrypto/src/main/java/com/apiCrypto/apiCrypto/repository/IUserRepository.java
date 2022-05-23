package com.apiCrypto.apiCrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiCrypto.apiCrypto.model.User;

@Repository
public interface IUserRepository extends JpaRepository <User, Long>{
  
 
}
