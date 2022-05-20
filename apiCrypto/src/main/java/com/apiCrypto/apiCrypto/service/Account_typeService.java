package com.apiCrypto.apiCrypto.service;



import com.apiCrypto.apiCrypto.model.Account_type;
import com.apiCrypto.apiCrypto.repository.IAccount_typeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Account_typeService {

    @Autowired
    private IAccount_typeRepository atR;

    public List<Account_type> getAll(){
        return atR.findAll();
    }

    public Account_type save (Account_type t){
        return atR.save(t);
    }

    public List <Account_type> getByAccount_type( long id_account_type){
        return atR.getbyIdAccount_type(id_account_type);
    }

    public void delete(long id_account_type) {
        atR.deleteByAccount_type(id_account_type);
    }

/*
    public Transaction make(){
        return tR.makeTransaction();
   }
   */


}