package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.User_Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserCoinRepository extends JpaRepository<User_Coin, Integer> {

    @Query(value = "Select * from User_Coin where id_user_userCoin = :id", nativeQuery = true)
   public User_Coin findByUserId(long id);

   }
