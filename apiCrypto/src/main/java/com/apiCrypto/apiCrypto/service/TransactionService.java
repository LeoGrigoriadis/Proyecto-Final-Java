package com.apiCrypto.apiCrypto.service;

import java.util.List;

import javax.transaction.Transactional;

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

    public Transaction save(Transaction u) {
      
            return  tR.save(u);
    }

    public List <Transaction> getByUser( long id){
        return tR.getbyIdUser(id);
    }

    public void delete(long id) {
        tR.deleteById(id);
    }

    @Transactional
    public boolean updateTransaction(Transaction p) {
        if (!tR.existsById(p.getId_transaction())) {
            return false;
        } else {
            tR.save(p);
            return true;
        }
    }

    public Transaction getTransaction(long id) {
        return tR.getById(id);
    }
/*
    public Transaction make(){
        return tR.makeTransaction();
   }
   */


}
