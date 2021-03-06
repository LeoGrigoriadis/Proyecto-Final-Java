package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Transaction;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class TransactionRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Transaction> findAll(long id){
        String url = "http://localhost:8090/api/Transaction/{id}";
        ArrayList<Transaction> transaction = rt.getForObject(url, ArrayList.class, id);
        return transaction;
    }

    public Transaction getOne(long id){
        String url = "http://localhost:8090/api/Transaction/getOne/{id}";
        Transaction transaction;
        transaction = rt.getForObject(url, Transaction.class, id);
        return transaction;
    }

    public void delete(long id) {
        String url = "http://localhost:8090/api/Transaction/delete/{id}";
        rt.delete(url, id);
    }

    public void save(Transaction es) {
        String url = "http://localhost:8090/api/Transaction/save";
        rt.postForObject(url, es, Transaction.class);
    }

    public void update(Transaction es) {
        String url = "http://localhost:8090/api/Transaction/update";
        rt.put(url, es, Transaction.class);
    }

    public void cobrar(User_Coin es) {
       // @PutMapping("/cobrarMonto/{balance}/{id_coin}/{id_user}")
        String url = "http://localhost:8090/api/Transaction/cobrarMonto/"+es.getBalance()+"/"+es.getId_coin().getId_coin()+"/"+es.getId_user().getId_user();
        rt.put(url, es, User_Coin.class);
    }

    public void depositar(User_Coin es) {
        //@PutMapping("/depositar/{balance}/{id_coin}/{id_user}")
        String url = "http://localhost:8090/api/Transaction/depositar/"+es.getBalance()+"/"+es.getId_coin().getId_coin()+"/"+es.getId_user().getId_user();
        rt.put(url, es, User_Coin.class);
    }

    public void cobraTodo(User_Coin es) {
        //  @PutMapping("/cobrarTodo/{id_coin}/{id_user}")
        String url = "http://localhost:8090/api/Transaction/cobrarTodo/"+es.getId_coin().getId_coin()+"/"+es.getId_user().getId_user();
        rt.put(url, es, User_Coin.class);
    }

    public ArrayList<Transaction> getLast(long id_user) {
        String url = "http://localhost:8090/api/Transaction/last/{id}";
        ArrayList<Transaction> transaction = new ArrayList<>();
        return transaction = rt.getForObject(url, ArrayList.class, id_user);
    }
}
