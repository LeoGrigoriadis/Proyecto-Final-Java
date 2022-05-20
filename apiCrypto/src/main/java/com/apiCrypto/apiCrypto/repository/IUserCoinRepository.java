package com.apiCrypto.apiCrypto.repository;

import com.apiCrypto.apiCrypto.model.User_Coin;

import java.util.List;

public interface IUserCoinRepository {
    Object findAll();

    List<Object> findById(long id);

    User_Coin save(User_Coin game);

    void deleteById(long id);
}
