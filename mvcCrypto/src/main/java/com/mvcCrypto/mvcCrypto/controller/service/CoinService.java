package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoinService {

    @Autowired
    private CoinRepository cr;


    public ArrayList<Object> getAll()
    {
        return (ArrayList<Object>) cr.findAll();
    }


    public Coin getByName(String name)
    {
        return cr.getByName(name);
    }
}
