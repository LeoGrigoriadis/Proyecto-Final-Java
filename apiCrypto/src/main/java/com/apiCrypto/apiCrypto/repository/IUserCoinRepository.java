package com.apiCrypto.apiCrypto.repository;
import com.apiCrypto.apiCrypto.model.User_Coin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface IUserCoinRepository extends JpaRepository<User_Coin,Long>{
    

    List<Object> findById(long id);

    @Query(value = "Select * from User_Coin where id_user = :id", nativeQuery = true)
    public ArrayList<User_Coin> findByUserId(long id);

 

    
}
