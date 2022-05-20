package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.User_Coin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserCoinRepository {
    Object findAll();

    List<Object> findById(long id);

    User_Coin save(User_Coin game);

    void deleteById(long id);
}
