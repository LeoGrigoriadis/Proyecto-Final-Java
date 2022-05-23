package com.apiCrypto.apiCrypto.service;

import java.util.List;

import com.apiCrypto.apiCrypto.model.Auth;
import com.apiCrypto.apiCrypto.repository.IAuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private IAuthRepository au;

    public List<Auth> getAll() {
        return au.findAll();
    }

    public boolean save(Auth u) {
        try {
            if (au.existsById(u.getGmail())) {
                au.save(u);

            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteUser(String id) {
        if (au.existsById(id)) {
            au.deleteById(id);
        }
    }

    public Auth getUser(String id) {
        return au.getById(id);
    }

    public boolean updateAuth(Auth u) {
        if (!au.existsById(u.getGmail())) {
            return false;
        } else {
            au.save(u);
            return true;
        }
    }
    
}
