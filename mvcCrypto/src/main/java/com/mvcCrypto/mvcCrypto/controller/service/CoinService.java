package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoinService {

    private CoinRepository cr;

    public ArrayList<Coin> getAll()
    {
        return (ArrayList<Coin>) cr.findAll();
    }


    public User getByName(String name)
    {
        return cr.getByName(name);
    }
}
