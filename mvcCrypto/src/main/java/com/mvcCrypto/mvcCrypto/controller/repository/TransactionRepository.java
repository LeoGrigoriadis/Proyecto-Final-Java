package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Transaction;
import com.mvcCrypto.mvcCrypto.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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

}
