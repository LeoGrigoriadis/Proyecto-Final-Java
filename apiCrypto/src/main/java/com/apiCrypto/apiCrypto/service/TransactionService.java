package com.apiCrypto.apiCrypto.service;

import java.util.List;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.repository.ITransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private ITransactionRepository tR;

    public List<Transaction> getAll(){
        return tR.findAll();
    }

    public Transaction save (Transaction t){
        return tR.save(t);
    }

    public List <Transaction> getByUser( long id){
        return tR.getbyIdUser(id);
    }

    public void delete(long id) {
        tR.deleteById(id);
    }

/*
    public Transaction make(){
        return tR.makeTransaction();
   }
   */


}
