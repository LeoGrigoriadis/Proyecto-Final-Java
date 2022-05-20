package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.CoinApiRepository;
import com.mvcCrypto.mvcCrypto.controller.repository.CoinExternoRepository;
import com.mvcCrypto.mvcCrypto.model.Coin;
import com.mvcCrypto.mvcCrypto.model.CoinAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CoinApiService {
    @Autowired
    private CoinApiRepository cr;


    public ArrayList<CoinAdapter> getAll()
    {
        return (ArrayList<CoinAdapter>) cr.findAll();
    }


    public CoinAdapter getOne(String id)
    {
        return cr.getOne(id);
    }

    public void delete (String id){
        cr.delete(id);
    }

    public void save (CoinAdapter coin){
        cr.save(coin);
    }
}
