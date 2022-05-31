package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.TransactionRepository;
import com.mvcCrypto.mvcCrypto.model.Transaction;

import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tr;



    public Transaction findById (long id){
        return tr.getOne(id);
    }

    public ArrayList<Transaction> getAll(long id){
        return tr.findAll(id);
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

    public void cobrar(User_Coin uc){
    tr.cobrar(uc);
    }

    public void cobrarTodo(User_Coin uc){
        tr.cobraTodo(uc);
    }

    public void depositar(User_Coin uc){
        tr.depositar(uc);
    }

    public ArrayList<Transaction> getLast(long id_user) { return tr.getLast(id_user); }
}
