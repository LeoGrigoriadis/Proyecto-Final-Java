package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Transaction;
import com.mvcCrypto.mvcCrypto.model.User;
import com.mvcCrypto.mvcCrypto.model.User_Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class TransactionRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Transaction> findAll(){
        String url = "http://localhost:8090/api/Transaction";
        ArrayList<Transaction> transaction = new ArrayList<>();
        transaction = rt.getForObject(url, ArrayList.class);

        return transaction;
    }

    public Transaction getOne(long id){
        String url = "http://localhost:8090/api/Transaction/getOne"+id;
        Transaction transaction;
        transaction = rt.getForObject(url, Transaction.class);
        return transaction;
    }

    public void delete(long id) {
        String url = "http://localhost:8090/api/Transaction/delete/" + id;
        rt.delete(url);
    }

    public void save(Transaction es) {
        String url = "http://localhost:8090/api/Transaction/save";
        rt.postForObject(url, es, Transaction.class);
    }

    public void update(Transaction es) {
        String url = "http://localhost:8090/api/Transaction/update";
        rt.put(url, es, Transaction.class);
    }


    public void cobrar(User_Coin us,double balance, String id_coin, long id_user){
        us.setBalance(balance);
        us.setId_coin(id_coin);
        us.setId_user(id_user);
        String url = "http://localhost:8090/api/Transaction/CobrarMonto/"+balance+"/"+id_coin+"/"+id_user;
        rt.put(url,us,User_Coin.class);
    }

    public void depositar(User_Coin us,double balance, String id_coin, long id_user){
        us.setBalance(balance);
        us.setId_coin(id_coin);
        us.setId_user(id_user);
        String url = "http://localhost:8090/api/Transaction/depositar/"+balance+"/"+id_coin+"/"+id_user;
        rt.put(url,us,User_Coin.class);
    }

    public void cobrarTodo(User_Coin us, String id_coin, long id_user){

        us.setId_coin(id_coin);
        us.setId_user(id_user);
        String url = "http://localhost:8090/api/Transaction/CobrarMonto/"+id_coin+"/"+id_user;
        rt.put(url,us,User_Coin.class);
    }
}
