package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoinExternoService {

    @Autowired
    private CoinExternoRepository cr;


    public ArrayList<Object> getAll()
    {
        return (ArrayList<Object>) cr.findAll();
    }


    public Object getByName(String name)
    {
        return cr.getByName(name);
    }
}
