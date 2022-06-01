package com.apiCrypto.apiCrypto.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.apiCrypto.apiCrypto.model.Auth;
import com.apiCrypto.apiCrypto.repository.IAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private IAuthRepository au;

    public List<Auth> getAll() {
        return au.findAll();
    }

    public Auth save(Auth u) {
        try {
                Auth auth=au.save(u);
                return auth;
     
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteAuth(String id) {
        try {
            au.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }
 
    public Optional<Auth> getAuth(String id) {
       
        return  au.findById(id);
    }



    @Transactional
    public boolean updateAuth(Auth u, String id) {
        if (au.getById(id )!= null) {
          u.setGmail(id);
          au.save(u);
          return true;
        } else {
            return false;
        }
    }

    public String  getRoleu (String gmail){
     
            return  au.getRole(gmail);
      
    }
    
}
