package com.apiCrypto.apiCrypto.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apiCrypto.apiCrypto.model.Coin;



@Repository
public interface ICoinRepository extends JpaRepository <Coin, String>{

    @Query(value = "SELECT * FROM Coin WHERE id_coin = :id_coin", nativeQuery = true)
    public Coin getById_coin(@Param("id_coin") String id);

}
