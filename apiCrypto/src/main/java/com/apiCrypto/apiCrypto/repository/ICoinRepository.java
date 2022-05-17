package com.apiCrypto.apiCrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiCrypto.apiCrypto.model.Coin;

@Repository
public interface ICoinRepository extends JpaRepository <Coin, Integer>{

}
