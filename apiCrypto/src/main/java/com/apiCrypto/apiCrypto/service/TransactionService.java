package com.apiCrypto.apiCrypto.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.Transaction;
import com.apiCrypto.apiCrypto.model.User;
import com.apiCrypto.apiCrypto.repository.ITransactionRepository;

import com.apiCrypto.apiCrypto.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private ITransactionRepository tR;
    @Autowired
    private IUserRepository ur;

    public List<Transaction> getAll() {
        return tR.findAll();
    }

    public Transaction save(Transaction u) {
        try {
            Transaction tt =tR.save(u);
            return tt;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Transaction> getByUser(long id) {
        return tR.getByIdUser(id);
    }

    /*public List<Transaction> getByUser(long id, int num, int size) {
        User user=ur.getById(id);
        List<Transaction> movs=tR.findAllByIduser(user, PageRequest.of(num-1, size, Sort.by("date").descending()));
        return movs;
    }*/

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

    @Transactional
    public void depositar(double balance, String id_coin, long id_user) {

       tR.Deposito(balance, id_coin, id_user);
    }

    @Transactional
    public void cobrarMonto(double balance, String id_coin, long id_user) {
       tR.CobrarMonto(balance, id_coin, id_user);
    }

    @Transactional
    public void CobrarTodo(String id_coin, long id_user) {
         tR.CobrarTodo(id_coin, id_user);
    }


    public List<Transaction> getLastByUser(long id) { return tR.getLastByUser(id); }
}