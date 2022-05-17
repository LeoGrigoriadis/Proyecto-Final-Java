package com.apiCrypto.apiCrypto.service;

import com.apiCrypto.apiCrypto.model.Trade;
import com.apiCrypto.apiCrypto.repository.ITradeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TradeService {

    private ITradeRepository tr;

    public List<Trade> getAll(){
        return tr.findAll();
    }

    public Trade save(Trade c)
    {
        if(tr.getById(c.getId_trade()) == null)
        {
            return  tr.save(c);
        }
        else
            return null;

    }

    public Optional<Trade> getById(long id)
    {
        return tr.findById(id);
    }

    @Transactional
    public Trade update(Trade c, long id)
    {
        if(tr.getById(id)!=null)
        {
            c.setId_trade(id);
            return  tr.save(c);
        }
        else {
            return  null;
        }

    }

    public boolean delete(long id)
    {
        try
        {
            tr.deleteById(id);
            return  true;
        }
        catch (EmptyResultDataAccessException e)
        {
            return false;
        }

    }

    public List<Trade> getByIdUser(long id) {
        return tr.getByIdUser(id);
    }
}


