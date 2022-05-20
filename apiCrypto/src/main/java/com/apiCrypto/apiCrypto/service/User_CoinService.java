package com.apiCrypto.apiCrypto.service;


import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.repository.IUserCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class User_CoinService {

    @Autowired
    private IUserCoinRepository ucR;

    public User_Coin getAll() {
        return (User_Coin) ucR.findAll();
    }

    public User_Coin getOne(int id_account) {

        return (User_Coin) ucR.findById(id_account).get(id_account);
    }

    public User_Coin save(User_Coin uc) {
        return ucR.save(uc);
    }

    public void delete(long id) {
        ucR.deleteById(id);
    }


}