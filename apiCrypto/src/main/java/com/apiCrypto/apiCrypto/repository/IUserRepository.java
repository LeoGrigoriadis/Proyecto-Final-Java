package com.apiCrypto.apiCrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.apiCrypto.apiCrypto.model.User;

@Repository
public interface IUserRepository extends JpaRepository <User, Long>{
   
    @Query(value = "SELECT * FROM users where users.gmail = :gmail", nativeQuery = true)
    public Optional<User> getByGmail(@Param("gmail") String gmail);
}
