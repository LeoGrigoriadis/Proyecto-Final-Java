package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.TransactionRepository;
import com.mvcCrypto.mvcCrypto.model.Transaction;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionService {

    private TransactionRepository tr;



    public Transaction findById (long id){
        return tr.getOne(id);
    }

    public ArrayList<Transaction> findAll(){
        return tr.findAll();
    }

    public  void delete(long id){
        tr.delete(id);
    }

    public void save(Transaction transaction){
        tr.save(transaction);
    }

    public void update (Transaction transaction){
        tr.update(transaction);
    }
}
