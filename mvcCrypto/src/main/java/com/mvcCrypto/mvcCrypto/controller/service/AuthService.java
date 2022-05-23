package com.mvcCrypto.mvcCrypto.controller.service;

import com.mvcCrypto.mvcCrypto.controller.repository.AuthRepository;
import com.mvcCrypto.mvcCrypto.model.Auth;
import com.mvcCrypto.mvcCrypto.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService {

    @Autowired
    private AuthRepository ar;

    public ArrayList<Auth> findAll(){
        return ar.findAll();
    }

    public  void delete(long id){
        ar.delete(id);
    }

    public void save(Auth auth){
        ar.save(auth);
    }

    public void update (Auth auth){
        ar.update(auth);
    }
}
