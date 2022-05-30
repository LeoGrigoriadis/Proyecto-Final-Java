package com.mvcCrypto.mvcCrypto.controller.repository;

import com.mvcCrypto.mvcCrypto.model.Account_type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Repository
public class Account_typeRepository {

    @Autowired
    private RestTemplate rt;

    public ArrayList<Account_type> findAll(){
        String url = "http://localhost:8090/api/Account";
        ArrayList<Account_type> account_type = new ArrayList<>();
        account_type = rt.getForObject(url, ArrayList.class);

        return account_type;
    }


    public void delete(long id) {
        String url = "http://localhost:8090/api/Account/delete/{var1}";
        rt.delete(url,id);
    }

    public void save(Account_type es) {
        String url = "http://localhost:8090/api/Account/save";
        rt.postForObject(url, es, Account_type.class);
    }

    public void update(Account_type es) {
        String url = "http://localhost:8090/api/Account/update";
        rt.put(url, es, Account_type.class);
    }
}
