package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.UserCoinRepository;
import com.mvcCrypto.mvcCrypto.model.Transaction;
import com.mvcCrypto.mvcCrypto.model.User;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class UserCoinService {

    @Autowired
    UserCoinRepository ur;

    public ArrayList<User_Coin> findAllByIdUser(long id){ return ur.findAllByIdUser(id); }

    public User_Coin findById (long idu, String idc){
        return ur.findByIdUserAndIdCoin(idu, idc);
    }

    public ArrayList<User_Coin> getAll(long id_user){
        return ur.findAll(id_user);
    }

    public  void delete(long id){
     ur.delete(id);
    }

    public void save(User_Coin uc){
        ur.save(uc);
    }

/*
    public double getTotalBalance(int id){
        ArrayList<User_Coin> user_coins=ur.findAllById(id);
        double balance=0;
        for (User_Coin uc:user_coins){
            balance+=uc.getBalance();
        }
        return balance;
    }
    */


}





