package com.apiCrypto.apiCrypto.service;


import com.apiCrypto.apiCrypto.model.User_Coin;
import com.apiCrypto.apiCrypto.repository.IUserCoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;


@Service
public class User_CoinService {

    @Autowired
    private IUserCoinRepository ucR;

    public List<User_Coin> getAll() {
        return ucR.findAll();
    }

    public User_Coin getOne(Long id){
        return ucR.getById(id);
    }

    public ArrayList<User_Coin> getAllByIdUser(Long idUser) {

        return ucR.findByUserId(idUser);
    }

    public User_Coin save(User_Coin uc) {
        return ucR.save(uc);
    }

    public void delete(long id) {
        ucR.deleteById(id);
    }

    @Transactional
    public boolean updateUserCoin(User_Coin uc) {
        if (!ucR.existsById(uc.getId_account())) {
            return false;
        } else {
            ucR.save(uc);
            return true;
        }
    }

}