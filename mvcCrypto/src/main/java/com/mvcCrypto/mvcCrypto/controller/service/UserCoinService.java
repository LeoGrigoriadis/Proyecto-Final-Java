package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.UserCoinRepository;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserCoinService {

    @Autowired
    UserCoinRepository ur;

    public ArrayList<User_Coin> findAllById(int id){ return ur.findAllById(id); }

    public double getTotalBalance(int id){
        ArrayList<User_Coin> user_coins=ur.findAllById(id);
        double balance=0;
        for (User_Coin uc:user_coins){
            balance+=uc.getBalance();
        }
        return balance;
    }
}
