package com.apiCrypto.apiCrypto.service;

import com.apiCrypto.apiCrypto.model.Coin;
import com.apiCrypto.apiCrypto.model.Trade;
import com.apiCrypto.apiCrypto.repository.ICoinRepository;
import com.apiCrypto.apiCrypto.repository.ITradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CoinService {

    @Autowired
    private ICoinRepository cr;

    public List<Coin> getAll(){
        return cr.findAll();
    }

    public Coin save(Coin c)
    {

            return  cr.save(c);


    }



    @Transactional
    public Coin update(Coin c, String id)
    {
        if(cr.getById_coin(id)!=null)
        {
            c.setId_coin(id);
            return  cr.save(c);
        }
        else {
            return  null;
        }

    }

    public boolean delete(String id)
    {
        try
        {
            cr.deleteById(id);
            return  true;
        }
        catch (EmptyResultDataAccessException e)
        {
            return false;
        }

    }

    public Coin getByIdCoin(String id) {
        return cr.getById_coin(id);
    }
}
