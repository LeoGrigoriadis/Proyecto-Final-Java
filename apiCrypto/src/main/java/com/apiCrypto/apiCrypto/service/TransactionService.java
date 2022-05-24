package com.apiCrypto.apiCrypto.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.repository.ITransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private ITransactionRepository tR;

    public List<Transaction> getAll() {
        return tR.findAll();
    }

    public boolean save(Transaction u) {
        try {
            tR.save(u);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Transaction> getByUser(long id) {
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

    public boolean depositar(double balance, String id_coin, long id_user) {

      return tR.Deposito(balance, id_coin, id_user);
    }

    public boolean CobrarMonto(double balance, String id_coin, long id_user) {
        return  tR.CobrarMonto(balance, id_coin, id_user);
    }

    public boolean CobrarTodo(String id_coin, long id_user) {
        return tR.CobrarTodo(id_coin, id_user);
    }

/*
    public Transaction make(){
        return tR.makeTransaction();
   }
   */

}